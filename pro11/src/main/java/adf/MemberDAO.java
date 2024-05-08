package adf;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection conn;
//   Statement stmt;

	private PreparedStatement pstmt;
	private DataSource dataFactory;

//   private void connDB() {
//      try {
//         Class.forName("oracle.jdbc.OracleDriver");
//         conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "testuser", "test1234");
//         stmt = conn.createStatement();
//      } catch (Exception e) {
//         e.printStackTrace();
//      }
//   }

	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		try {
			conn = dataFactory.getConnection();

			String query = "delete from t_member where id = ?";
			System.out.println("prepareStatement : " + query);
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addMember(MemberVO memberVO) {
		try {
			conn = dataFactory.getConnection();

			String id = memberVO.getId();
			String pwd = memberVO.getPwd();
			String name = memberVO.getName();
			String email = memberVO.getEmail();

			String query = "insert into t_member";
			query += " (id, pwd, name, email)";
			query += " values(?,?,?,?)";

			System.out.println("prepareStatement: " + query);
			pstmt = conn.prepareStatement(query);

			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers(String keyword, String searchType) {
		List<MemberVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
//         connDB();
			conn = dataFactory.getConnection();

			String query = "select * from testuser";

			if (keyword != null && "all".equals(searchType)) {
				if (!"all".equals(searchType)) {
					query += " where " + searchType + " LIKE '%" + keyword + "%'";
				}
			}

			pstmt = conn.prepareStatement(query);
//         stmt = conn.createStatement();
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate");
				MemberVO vo = new MemberVO();
				vo.setId(id);
				vo.setPwd(pwd);
				vo.setName(name);
				vo.setEmail(email);
				vo.setJoinDate(joinDate);
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public MemberVO login(MemberVO memberVO) {

		MemberVO vo = null; // memberVO 객체 생성 후 초기화
		String id = memberVO.getId();
		String pwd = memberVO.getPwd();
		
		try {
			conn = dataFactory.getConnection();
			String query = "select * from testuser where id=? and pwd=?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				vo = new MemberVO();
				vo.setId(rs.getString("id"));
				vo.setName(rs.getString("name"));
				vo.setEmail(rs.getString("email"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
}
