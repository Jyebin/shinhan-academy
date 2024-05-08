package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/member")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		MemberDAO dao = new MemberDAO();
		List<MemberVO> list = dao.listMembers();
		System.out.println(list);
		PrintWriter out = response.getWriter();
		System.out.print("<table border=1><tr align='center' bgcolor='white'>");
		for(int i=0;i<list.size();i++) {
			MemberVO memberVO = list.get(i);
			out.print("<tr>");
		}
	}

}
