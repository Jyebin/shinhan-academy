package chapter10;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
	@GetMapping("/member/insert.do")
	public String insert() {
		return "member/write";
	}

	@Autowired // 필드는 어디서 쓰던 상관이 없어서 어노테이션을 중간에 써도 됨
	private MemberService service;

	@PostMapping("/member.insert.do")
	public String insert(MemberVO vo) { // @ModelAttribute를 VO안에 써야함
		System.out.println(Arrays.toString(vo.getHobbyName()));
		service.insert(vo);
		// 서블릿으로 응답

		return "";
	}

	@GetMapping("/member/idCheck.do")
	public void idCheck(String id, HttpServletResponse res) throws IOException {
		int r = service.idCheck(id); // 주입하는 객체로 메소드 호출
		PrintWriter pw = res.getWriter();
		pw.print(r);
		pw.close();
		// 이제 jsp에서 호출해야 함
	}

	@GetMapping("/member/login.do")
	public String login(MemberVO vo, HttpServletResponse res, HttpSession sess) throws Exception {
		MemberVO login = service.login(vo);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		if (login == null) { // 로그인 실패
			pw.println("<script>");
			pw.println("alert('아이디 비번이 잘못됐습니다.');");
			pw.println("history.back();");
			pw.println("</script>");
		} else { // 로그인 성공 -> 세션 저장
			sess.setAttribute("login", login);
			res.sendRedirect("event.do");
		}
		pw.close();
	}

	@GetMapping("/member/mypage.do")
	public String mypage(Model model, HttpSession sess) {
		int no = ((MemberVO) sess.getAttribute("login")).getNo();
		MemberVO data = service.mypage(no);
		model.addAttribute("data", data);
		return "/member/mypage";
	}

	@PostMapping("/member/login.do")
	public void login(MemberVO vo) {
		MemberVO login = service.login(vo);
	}
}
