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
	private Connection con;
	private Statement stmt;
	private PreparedStatement pstmt;

	private DataSource dataFactory;

	public MemberDAO() {
        try {
            Context ctx = new InitialContext();
            Context envContext = (Context)ctx.lookup("java:/comp/env");
            dataFactory = (DataSource)envContext.lookup("jdbc/mysql"); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	public List<MemberVO> listMembers(String searchType, String searchWord) {
		List<MemberVO> list = new ArrayList<>();
		ResultSet rs = null;
		try {
			con = dataFactory.getConnection();
			String query = "SELECT * FROM testuser";
			String whereQuery = "";
			if (searchWord != null && !"".equals(searchWord)) {
				if ("all".equals(searchType)) {
					whereQuery = " WHERE id LIKE '%" + searchWord + "%' OR name LIKE '%" + searchWord
							+ "%' OR email LIKE '%" + searchWord + "%'";
				} else {
					whereQuery = " WHERE " + searchType + " LIKE '%" + searchWord + "%'";
				}
			}
			query += whereQuery;
			pstmt = con.prepareStatement(query);
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
				rs.close();
			} catch (Exception e) {
			}
			try {
				pstmt.close();
			} catch (Exception e) {
			}
			try {
				con.close();
			} catch (Exception e) {
			}
		}

		return list;
	}

}
