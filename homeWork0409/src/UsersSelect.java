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
            String sql = "SELECT * FROM USERS WHERE USER_ID = ?"; //sql의 쿼리

            PreparedStatement pstmt = conn.prepareStatement(sql); //db에 대해 준비된 명령문 생성. 나중에 실행할 쿼리를 지정하고 실행될 때마다 재사용됨
            pstmt.setInt(1, 1);
            ResultSet rs = pstmt.executeQuery(); //객체에 대한 SQL 쿼리를 실행하고 그 결과를 담은 ResutlSet 객체 반환(결과 집합 반환)

            if (rs.next()) { //각 열의 데이터를 가져와 Users의 각 필드에 설정
                Users user = new Users();
                user.setUserId(rs.getInt("USER_ID")); //db의 칼럼 명과 동일해야 함. resultSet에서 해당 열의 데이터를 갖고옴
                user.setUserName(rs.getString("USER_NAME"));
                user.setPw(rs.getString("PW"));
                user.setBirth(rs.getString("BIRTH"));
                user.setEmail(rs.getString("EMAIL"));
                user.setAddress(rs.getString("ADDRESS"));
                user.setSexCode(rs.getInt("SEX_CODE"));
                user.setAccountNum(rs.getString("ACCOUNT_NUM"));
                System.out.println(user);
            } else {
                System.out.println("사용자 아이디가 존재하지 않음");
            }
            //리소스 정리
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
