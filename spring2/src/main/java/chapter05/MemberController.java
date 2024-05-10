package chapter05;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MemberController {
	// ReqeustMapping : method가 없는 경우에는 모든 method가 가능
	@RequestMapping({ "/member/index.do", "/member/index2.do", "/member.do" }) // 요청을 mapping시키는 것
	public String index() {
		System.out.println("index");
		return "member/index"; // views안의 member안의 jsp파일
	}

	// /index.do URL로 GET 방식만 접근
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String index2() {
		System.out.println("index");
		return "home";
	}

	// /index2.do GET
	@GetMapping("/index2.do")
	public String index22() {
		return "member/index"; // /WEB-INF/views/[].jsp
	}
	
	// /member/test/index.do
	@GetMapping("/test/index.do")
	public void test() {
		//void인 경우 URL과 동일한 경로로 포워딩
	}
	
	//리다이렉트
	// /member/test.do -> /member/test/index.do
	@GetMapping("/test.do")
	public String test2() {
		//context변수까지 쓰고싶은경우 : return "redirect: /test/member/test/index.do" 공백필수
		return "redirect:/member/test/index.do";
	}
}