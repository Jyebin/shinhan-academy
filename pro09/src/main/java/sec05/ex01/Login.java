package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login.do")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * 1. 파라미터(아이디, 비밀번호)를 받아야 함 2. MemberDAO 객체 생성 3. MemberVO 객체 생성 후 아이디, 비밀번호 저장
	 * 4. login메소드 실행(MemberVO 객체 전달) 5. login 메소드의 return값을 받아 null인 경우와 null이 아닌
	 * 경우의 처리 로직 작성 null인 경우 : '아이디 비밀번호가 올바르지 않습니다' alert null이 아닌 경우 : redirect
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// id, pw받아오기
		String id = request.getParameter("user_id");
		String pw = request.getParameter("user_pw");
		System.out.println("user_id: " + id);
		// MemberDAO 객체 생성
		MemberDAO dao = new MemberDAO();
		// MemberVO 객체 생성, 아이디, 비밀번호 저장
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setPwd(pw);
		// login메서드 실행(MemberVO 객체 전달)
		MemberVO loginVO = dao.login(vo); // login메서드 리턴값을 받아
		// null 이면 : '아이디 비밀번호가 올바르지 않습니다.' alert
		if (loginVO == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 비밀번호가 올바르지 않습니다.');");
			out.println("location.href='login.html';");
			out.println("</script>");
		} else { // null이 아니면 : redirect (main.do)
			request.getSession().setAttribute("loginSession", loginVO);
			response.sendRedirect("main.do");
		}
	}
}