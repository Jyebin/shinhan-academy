import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class BoardSelectExample {
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
            String sql = "" + "SELECT BNO, BTITLE, BCONTENT, BWRITER, BDATE, BFILENAME, BFILEDATA FROM BOARD WHERE BWRITER = ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            int pstmtInt = 1;
            pstmt.setString(pstmtInt++, "winter");
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) { //1개의 데이터 행을 가져왔을 경우
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontetn"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                board.setBfilename(rs.getString("bfilename"));
                board.setBfiledata(rs.getBlob("bfiledata"));
                System.out.println(board);

                Blob blob = board.getBfiledata();
                if (blob != null) {
                    InputStream is = blob.getBinaryStream();
                    OutputStream os = new FileOutputStream("D:/"+board.getBfilename());
                    is.transferTo(os);
                    os.flush();
                    os.close();
                    is.close();
                }
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


