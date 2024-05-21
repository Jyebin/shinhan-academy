package chapter12;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MemberController {
	@GetMapping("/member/insert.do")
	public String insert() {
		return "member/write";
	}

	@Autowired // 필드는 어디서 쓰던 상관이 없어서 어노테이션을 중간에 써도 됨
	private MemberService service;

	@PostMapping("/member.insert.do")
	public String insert(MemberVO vo, @RequestParam("profile") MultipartFile profile, HttpServletRequest req) { // @ModelAttribute를
																												// VO안에
																												// 써야함
		System.out.println(Arrays.toString(vo.getHobbyName()));

		// 파일 저장
		if (!profile.isEmpty()) { // false여야 실행(비어있지 않으면 = 사용자가 첨부 파일을 첨부 한 경우 실행)
			System.out.println(profile.getOriginalFilename()); // getOriginalFilename 메소드 : 사용자가 첨부한 파일명이 return됨

			// 파일명 변경
			String org = profile.getOriginalFilename();
			String ext = org.substring(org.lastIndexOf(".")); // .이 들어 있는 것을 오른쪽 끝에서(뒤에서) 부터 끝(맨 앞)까지 찾아서 가져오는 것
			System.out.println(ext);
			String real = System.currentTimeMillis() + ext;

			// /upload 폴더에 저장(/upload 서버의 절대 경로)
			// getRealPath() -> D:/java/workspace_sts/.metadata/...가 나옴
			String path = req.getRealPath("/upload/");
			//String path = "컴퓨터 상에서의 실제 경로"; -> 배포 이후에는 경로를 수정 해 주어야 함
			//저장
			try {
				profile.transferTo(new File(path + real)); // 위에서 절대 경로를 /upload로 할거면 (path + "/" + real)로 적어주기
			} catch (Exception e) {
				vo.setFilename_org(org);
				vo.setFilename_real(real);
			}
		}

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

	@PostMapping("/member/login.do")
	public void login(MemberVO vo, HttpServletResponse res, HttpSession sess) throws Exception {
		MemberVO login = service.login(vo);
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html;charset=utf-8");
		if (login == null) { // 로그인 실패
			pw.println("<script>");
			pw.println("alert('아이디 비밀번호가 잘못됬습니다.');");
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
//
//	@PostMapping("/member/login.do")
//	public void login(MemberVO vo) {
//		MemberVO login = service.login(vo);
//	}
}
