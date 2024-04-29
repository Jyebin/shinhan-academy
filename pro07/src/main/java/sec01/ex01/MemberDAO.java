package sec01.ex01;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;

public class MemberDAO {
	private Connection conn;
	private Statement stmt;
	private PreparedStatement pstmt;

	public MemberDAO() {
	   try {
		   Context ctx = new InitialContext();
		   Context envContext = (Context)ctx.lookup9"java:/comp/env"); //정해진 것. 환경 값들을 찾는 것
		   dataFactory = (DataSource) envContext.lookup("jdbc/mysql"); //DataSource형태로 형변환. 원래는 object type이기 때문
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
   }

	private void connDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testuser", "root", "root");
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers() {
		List<MemberVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			//connDB();
			String query = "select * from t_member";
			//rs = stmt.executeQuery(query);
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
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
//			try {
//				conn.close();
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
		}
		return list;
	}
}