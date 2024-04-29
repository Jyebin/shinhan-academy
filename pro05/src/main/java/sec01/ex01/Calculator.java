package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calculator")
public class Calculator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private void process(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		res.setContentType("text/html;charset=utf-8"); // setContentType에다 해줘야 함

		// 연산
		String v1 = req.getParameter("v1") == null ? "" : req.getParameter("v1");
		String v2 = req.getParameter("v2");
		String op = req.getParameter("op");
		String result = "";
		if (v1 != null && v2 != null && op != null) { // 값이 있는 경우
			if ("+".equals(op)) { // 비교할 값을 항상 앞에다 넣는 습관 길들이기
				result = Integer.parseInt(v1) + Integer.parseInt(v2) + "";
			} else if ("-".equals(op)) {
				result = Integer.parseInt(v1) - Integer.parseInt(v2) + "";
			} else if ("*".equals(op)) {
				result = Integer.parseInt(v1) * Integer.parseInt(v2) + "";
			} else if ("-".equals(op)) {
				result = Double.parseDouble(v1) / Double.parseDouble(v2) + "";
			}
		}

		PrintWriter pw = res.getWriter();
		pw.println("<h1>계산기</h1>");
		pw.println("<form action='calculator' method='post'>");
		pw.println("<input type='text' name=v1' size=3 value='" + v1 + "'>");
		pw.println("<select name='op'>");
		pw.println("<option value='+' " + ("+".equals(req.getParameter("op")) ? "selected" : "") + ">+</option>");
		pw.println("<option value='-' " + ("-".equals(req.getParameter("op")) ? "selected" : "") + ">-</option>");
		pw.println("<option value='*' " + ("*".equals(req.getParameter("op")) ? "selected" : "") + ">*</option>");
		pw.println("<option value='/' " + ("/".equals(req.getParameter("op")) ? "selected" : "") + ">/</option>");
		pw.println("</select>");
		pw.println("<input type='text' name='v2' size=3 value='" + v2 + "'>");
		pw.println("<input type='submit' name='='>");
		pw.println("<input type='text' size=3 value='" + result + "'>");
		pw.println("</form>");
	}

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		process(req, res);
	}

}