package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login") //get, post 요청 모두 실행됨
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		// 응답
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		response.setContentType("text/html;charset=utf-8"); //응답은 setContentType
		PrintWriter out = response.getWriter();
		out.println("<h1>아이디:"+id+"</ht>");
		out.println("<h1>비밀번호:"+pw+"</ht>");
		out.flush(); //갱신. 안에들어있는 것을 비우는 것
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		process(req, response);
	}

	// HttpServletRequest는 인터페이스
	protected void process(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8"); //요청 시 캐릭터 인코딩 값. 한글을 인코딩 해 주어야 잘 나옴. 안그럼 깨짐
		String id = req.getParameter("user_id");
		String pw = req.getParameter("user_pw");
		System.out.println("ID:" + id);
		System.out.println("PW:" + pw);
		String[] subject = req.getParameterValues("subject");
		for (String str : subject) {
			System.out.println("선택한 과목:" + str);
		}
		Enumeration<String> names = req.getParameterNames();
		String name = names.nextElement();
		System.out.println(name);
	}
}

//개발자 모드에서 보면 payload에 전송된 내용이 나옴