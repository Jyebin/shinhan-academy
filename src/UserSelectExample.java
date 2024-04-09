import java.sql.*;

public class UserSelectExample {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "TESTUSER",
                    "TEST1234"
            );
            String sql = "" + "SELECT USERID, USERNAME, USERPASSWORD, USERAGE, USEREMAIL " + "FROM USERS " + "WHERE USERID = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            int pstmtInt = 1;
            pstmt.setString(pstmtInt++, "winter");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { //1개의 데이터 행을 가져왔을 경우
                User user = new User();
                user.setUserId(rs.getString("userId"));
                user.setUserName(rs.getString("userName"));
                user.setUserPassword(rs.getString("userPassword"));
                user.setUserAge(rs.getInt(4));
                user.setUserEmail(rs.getString(5));
                System.out.println(user);
            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }
            rs.close();
            pstmt.close();
        } catch (
                Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                }
            }
        }

    }
}


