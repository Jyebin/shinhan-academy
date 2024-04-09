import java.sql.*;
import java.util.Scanner;

public class BoardExample4 {
    private Scanner sc = new Scanner(System.in);
    private Connection conn;

    public BoardExample4() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521/xe",
                    "TESTUSER",
                    "TEST1234"
            );
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }

    public void list() {
        System.out.println();
        System.out.println("[게시물 목록]");
        System.out.println("---------------------------------------------");
        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
        System.out.println("---------------------------------------------");

        try {
            String sql = "" + "SELECT BNO, BTITLE, BCONTENT, BWRITER, BDATE " + "FROM BOARDS" + "ORDER BY BNO DESC";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                newBoard board = new newBoard();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(), board.getBtitle());
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            exit();
        }
        mainMenu();
    }

    public void mainMenu() {
        System.out.println();
        System.out.println("---------------------------------------------");
        System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Exit");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.nextLine();
        System.out.println();

        switch (menuNo) {
            case "1" -> create();
            case "2" -> read();
            case "3" -> clear();
            case "4" -> exit();
        }
    }

    public void create() {
        newBoard board = new newBoard();
        System.out.println("[새 게시물 입력]");
        System.out.print("제목: ");
        board.setBtitle(sc.nextLine());
        System.out.print("내용: ");
        board.setBcontent(sc.nextLine());
        System.out.print("작성자: ");
        board.setBwriter(sc.nextLine());

        System.out.println("---------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = sc.nextLine();
        if (menuNo.equals("1")) {
            try {
                String sql = "" + "INSERT INTO BOARDS (BNO, BTITLE, BCONTENT, BWRITER, BDATE) " + "VALUES (SEQ_BNO.NEXTVAL, ?, ?, ?, SYSDATE)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, board.getBtitle());
                pstmt.setString(2, board.getBcontent());
                pstmt.setString(3, board.getBwriter());
                pstmt.executeUpdate();
                pstmt.close();
            } catch (Exception e) {
                e.printStackTrace();
                exit();
            }
        }
        list();
    }

    public void read() {
        System.out.println("*** read() 메소드 실행됨");
        list();
    }

    public void clear() {
        System.out.println("*** clear() 메소드 실행됨");
        list();
    }

    public void exit() {
        System.exit(0);
    }

    public static void main(String[] args) {
        BoardExample2 boardExample = new BoardExample2();
        boardExample.list();
    }
}
