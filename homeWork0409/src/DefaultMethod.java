import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

import static java.lang.System.exit;

public class DefaultMethod {
    private Scanner sc = new Scanner(System.in);
    private Connection connection;

    public DefaultMethod() {
        try {
            //JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            //연결하기
            connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe", "BANKUSER", "BANK1234");
        } catch (Exception e) {
            e.printStackTrace();
            exit();
        }
    }
    public void list(){
        System.out.println();
        System.out.println("\uD83C\uDFE6"); //은행 이모티콘의 유니코드 문자
        System.out.println("\uD83D\uDCB0"); //돈다발 이모티콘
        System.out.println("어서오세요 은행입니다");
    }

    public void exit(){
        if(connection != null){
            try{
                connection.close();
            }catch(Exception e){}
        }
        System.out.println("은행 프로그램을 종료합니다");

        System.exit(0);
    }
    public static void main(String[] args) {
        DefaultMethod dm = new DefaultMethod();
        dm.list();
    }
}
