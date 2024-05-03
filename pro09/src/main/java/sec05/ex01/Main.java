package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/main.do")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession();
		// 로그인 안했으면 null, 로그인 했으면 id, name, email이 들어있는 객체가 리턴
		MemberVO vo = (MemberVO) sess.getAttribute("loginSession");

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if (vo == null) {
			// 미로그인
			out.print("<a href='login.html'>로그인</a>");
		} else {

			// 로그인
			out.print(vo.getName()+"님 안녕하세요");
			out.print("<a href='login.html'>로그아웃</a>");
		}
	}

}
