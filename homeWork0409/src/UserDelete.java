import java.sql.*;

public class UserDelete {
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
            String sql = "DELETE FROM USERS WHERE USER_ID = ?"; //sql의 쿼리
            PreparedStatement pstmt = conn.prepareStatement(sql); //db에 대해 준비된 명령문 생성. 나중에 실행할 쿼리를 지정하고 실행될 때마다 재사용됨
            pstmt.setInt(1, 1);
            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수 : " + rows);
            pstmt.close();
        } catch (Exception e) {
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