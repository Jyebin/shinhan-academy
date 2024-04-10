import java.sql.*;

public class UserInsert {


    public static void main(String[] args) {
        Connection conn = null;
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            //연결하기
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "BANKUSER", "BANK1234");
            String sql = "INSERT INTO USERS (USER_ID, USER_NAME, PW, BIRTH, EMAIL, ADDRESS, SEX_CODE, ACCOUNT_NUM) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql); //db에 대해 준비된 명령문 생성. 나중에 실행할 쿼리를 지정하고 실행될 때마다 재사용됨
            pstmt.setInt(1, 1); //userId
            pstmt.setString(2, "김하나"); //userName
            pstmt.setString(3, "password123"); //pw
            pstmt.setString(4, "20010101"); //birth
            pstmt.setString(5, "one@example.com"); //email
            pstmt.setString(6, "서울시 마포구"); //address
            pstmt.setInt(7, 1); //sexCode
            pstmt.setString(8, "123-456-789"); //number

            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수: " + rows);
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
