import java.sql.*;

public class UsersSelect {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            //연결하기
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "BANKUSER",
                    "BANK1234"
            );
            String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql); //SQL문 실행
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery(); //객체에 대한 SQL 쿼리를 실행하고 그 결과를 담은 ResutlSet 객체 반환
            if (rs.next()) { //1개의 데이터 행을 가져왔을 경우
                Users user = new Users();
                user.setUserId(rs.getInt(1));
                user.setUserName(rs.getString("userName"));
                user.setPw(rs.getString("pw"));
                user.setBirth(rs.getString("birth"));
                user.setEmail(rs.getString("email"));
                user.setAddress(rs.getString("address"));
                user.setSexCode(rs.getInt(1));
                user.setAccountNum(rs.getString("accountNum"));
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
