package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/gugu")
public class GuguTest extends HttpServlet {

	private void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html;charset=utf-8");

		String num = req.getParameter("num"); // 입력받은 수
		String result = ""; // 결과값


		PrintWriter pw = res.getWriter();
		pw.println("<h1>출력할 구구단의 수를 지정해 주세요.</h1>");
		pw.println("<form action='gugu' method='post'>");
		pw.println("<form>출력할 구구단 :");
		pw.println("<input type='text' name='num'><br>");
		pw.println("<input type='submit' name='num'>");
		pw.println("<table border=1 width=800 align=center>");
		pw.println("<td colspan=2 align = center>" + num + "단 출력");
		
		for (int i = 1; i < 10; i++) { // 출력할 열
			pw.println("<tr align = center>");
			pw.println("<td>");
			pw.print(num + " * " + i);
			pw.println("<td>");
			pw.print(i * Integer.parseInt(num));
			pw.print("</td>");
			pw.print("<tr>");
		}
		pw.println("</table>");

	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}
}