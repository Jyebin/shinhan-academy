package sec04.ex02;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first7")
public class FirstServlet7 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		request.setAttribute("address", "서울시 성북구"); //브라우저의 최초 요청 request에 바인딩
		
		RequestDispatcher dispatch = request.getRequestDispatcher("second"); //바인딩된 request를 다시 두 번째 서블릿으로 포워드
		dispatch.forward(request, response);
	}
}
