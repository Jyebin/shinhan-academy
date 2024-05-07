package test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.MemberVO;

@WebServlet("/jstl")
public class JstlTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("name", "홍길동");
		HttpSession sess = request.getSession();
		sess.setAttribute("id", "hong");
		sess.setAttribute("name", "김길동");
		MemberVO vo = new MemberVO();
		vo.setId("choi");
		vo.setName("최길동");
		request.setAttribute("test", vo);
		
		Map<String, Object> map = new HashMap<>();
		map.put("tel", "010-1234-5678");
		map.put("vo", vo);
		request.setAttribute("map", map);
		
		sess.setAttribute("loginSession", vo);
		
		List<MemberVO> list = new ArrayList<>();
		list.add(vo);
		vo = new MemberVO();
		vo.setId("lee");
		vo.setName("이길동");
		list.add(vo);
		vo = new MemberVO();
		vo.setId("choi");
		vo.setName("최길동");
		list.add(vo);
		request.setAttribute("memberList", list);
		
		// 포맷(숫자 천단위컴마, 날짜)
		request.setAttribute("price", 100000);
		request.setAttribute("today", new Date());
		
		// 인스턴스
		request.setAttribute("test", new Test());
		
		request.getRequestDispatcher("/jstl/index.jsp").forward(request, response);
	}

}
