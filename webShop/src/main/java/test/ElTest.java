package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberVO;

@WebServlet("/el")
public class ElTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("name", "홍길동");
		HttpSession sess = request.getSession();
		sess.setAttribute("id", "hong");
		sess.setAttribute("name", "김길동");
		MemberVO vo = new MemberVO();
		vo.setId("choi");
		vo.setName("최길동");
		request.setAttribute("memberVO", vo);
		
		Map<String, String> map = new HashMap<>();
		map.put("tel","010-1234-5678");
		
		
		
		request.getRequestDispatcher("/el/index.jsp").forward(request, response);
	}

}
