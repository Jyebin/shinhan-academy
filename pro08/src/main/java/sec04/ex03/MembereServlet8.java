package sec04.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member8")   
public class MemberServlet8 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
      res.setContentType("text/html;charset=utf-8");
      PrintWriter out = res.getWriter();
      MemberDAO dao = new MemberDAO();
      List<MemberVO> list = dao.listMembers();
      out.print("<table border=1>");
      out.print("<tr align='center' bgcolor='lightgreen'>");
      out.print("<td> 아이디 </td>");
      out.print("<td> 비밀번호 </td>");
      out.print("<td> 이름 </td>");
      out.print("<td> 이메일 </td>");
      out.print("<td> 가입일 </td>");
      out.print("</tr>");
      for (int i = 0; i < list.size(); i++) {
         MemberVO memberVO = list.get(i);
         out.print("<tr>");
         out.print("   <td>" + memberVO.getId() + "</td>");
         out.print("   <td>" + memberVO.getPwd() + "</td>");
         out.print("   <td>" + memberVO.getName() + "</td>");
         out.print("   <td>" + memberVO.getEmail() + "</td>");
         out.print("   <td>" + memberVO.getJoinDate() + "</td>");
         out.print("</tr>");
      }
         
      System.out.println(list);
   }
}