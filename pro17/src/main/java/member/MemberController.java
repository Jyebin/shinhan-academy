package member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member/*")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDAO dao;

	public void init() throws ServletException {
		System.out.println("처음 한 번만 실행");
		dao = new MemberDAO();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = null;
		String action = request.getPathInfo();
		System.out.println("action:" + action);
		if ("/memberList.do".equals(action)) {
			// 비즈니스 로직 처리
			List<MemberVO> list = dao.listMembers(null, null);
			// 결과 저장
			request.setAttribute("memberList", list);
			page = "/.WEB-INF/view/member.jsp";
		} else if ("/addMember.do".equals(action)) {
			MemberVO vo = new MemberVO();
			vo.setId(request.getParameter("id"));
			vo.setId(request.getParameter("name"));
			vo.setId(request.getParameter("pwd"));
			vo.setId(request.getParameter("email"));
			dao.addMember(vo);
			request.setAttribute("msg", "정상적으로 등록되었습니다.");
			request.setAttribute("url", "/pro17/member/memberList.do");
			page = "/WEB-INF/view/include/alert.jsp";
		} else if ("/memberForm.do".equals(action)) {
			page = "/WEB-INF/view/memberForm.jsp";
		}
		// 뷰로 포워딩
		request.getRequestDispatcher("/WEB-INF/view/member.jsp").forward(request, response);
	}
}