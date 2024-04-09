import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BoardWithFileInsertExample {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "TESTUSER", "TEST1234");

            String sql = "INSERT INTO boards (bno, btitle, bcontent, bwriter, bdate, bfilename, bfiledata)"+
                    " VALUES (SEQ_BNO.NEXTVAL, ?,?,?,SYSDATE, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] {"bno"});
            int pstmtInt = 1;
            pstmt.setString(pstmtInt++, "눈 오는 날");
            pstmt.setString(pstmtInt++, "함박눈이 내려요.");
            pstmt.setString(pstmtInt++, "winter");
            pstmt.setString(pstmtInt++, "snow.jpg");
            pstmt.setBlob(pstmtInt++, new FileInputStream("D:\\text.txt"));
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : "+rows);

            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int bno = rs.getInt(1);
                    System.out.println("저장된 bno: "+bno);
                }
            }
            pstmt.close();
        }catch(Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        } finally {
            try {conn.close();}catch(Exception e) {}
        }

    }

}