package sec04.ex01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first6")
public class FirstServlet6 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("address", "서울시 성북구"); //웹 브라우저에서 요청한 request 객체에 address 값으로 서울시 성북구를 바인딩
		response.sendRedirect("second6"); //두 번째 서블릿으로 전달하기 위함
	}
}
