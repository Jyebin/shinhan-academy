package book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.NaverAPI;

@WebServlet("/book/list.do")
public class BookList extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String searchWord = request.getParameter("searchWord"); // 클라이언트에서 전송되는 파라미터 값이랑 정확하게 일치해야 함
		NaverAPI n = new NaverAPI();
		String result = n.getBookList(searchWord);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter w = response.getWriter();
		w.println(result);
	}

}
