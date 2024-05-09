//package test;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//
//@WebServlet("/member/index.do")
//public class MemberServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		String searchType = request.getParameter("searchType");
//		String searchWord = request.getParameter("searchWord");
//		ElTest dao = new ElTest();
//		List<MemberVO> list = dao.listMembers(searchType, searchWord);
//		request.setAttribute("list", list);
//		RequestDispatcher rd = request.getRequestDispatcher("/member.jsp");
//		rd.forward(request, response);
//	}
//
//}
