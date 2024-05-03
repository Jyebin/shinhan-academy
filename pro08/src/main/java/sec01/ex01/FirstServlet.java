package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request 객체에 저장
		request.setAttribute("name","홍길동");
		//request 객체에서 출력
		System.out.println("name:"+request.getAttribute("name"));
		//session객체에 저장
		HttpSession session = request.getSession();
		session.setAttribute("id", "hong");
		System.out.println("id:"+session.getAttribute("id"));
		}

	
}
