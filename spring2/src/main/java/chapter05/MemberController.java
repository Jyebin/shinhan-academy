package chapter05;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
		// void인 경우 URL과 동일한 경로로 포워딩
	}

	// 리다이렉트
	// /member/test.do -> /member/test/index.do
	@GetMapping("/test.do")
	public String test2() {
		// context변수까지 쓰고싶은경우 : return "redirect: /test/member/test/index.do" 공백필수
		return "redirect:/member/test/index.do";
	}

	// 파라미터 받는 방법
	// 1. HttpServletRequest(servlet에서는 tomcat이 이 객체 생성. doGet, doPost 사용)
	@GetMapping("/param1.do")
	public String param1(HttpServletRequest req) {
		String id = req.getParameter("id");
		System.out.println("id:" + id);
		return "member/param1";
	}

	// 2. RequestParam
	@GetMapping("/param2.do")
	public String param2(@RequestParam(name = "id", required = false, defaultValue = "nobody") String ids,
			@RequestParam int age) { // age부분에 ReqeustParam 어노테이션을 제거해도 돌아감
		String id = "";
		System.out.println("id:" + ids);
		System.out.println("age:" + age);
		return "member/param1";
	}

	// 3. 커맨드 객체(@ModeulAttribute)
	// 파라미터 이름과 setter이름이 같아야 함(이름:id -> setter:setId())
	// 모든 파라미터 중 해당하는 값을 vo에 저장(배열로 선언하면 알아서 배열로 들어감)
	// request에도 저장
	@GetMapping("/param3.do")
	public String param3(MemberVO vo) { // 알아서 다 담김
		// ModelAttribute("mem") MemverVO vo라고 써도 됨
		System.out.println(vo);
		return "member/param1";
	}

	// 4. @PathVariabl. 경로가 변수로 처리되는 것. {}안의 값이 달라짐.
	// /member/view/kim -> kim 값이 id 변수에 저장
	@GetMapping("/view/{id}/{name}") // 경로에 파라미터가 들어 있음. ex)Tstory
	public String parma4(@PathVariable String id, @PathVariable String name) {
		System.out.println("id:" + id);
		System.out.println("name:" + name);
		return "member/param1";
	}
//	
//	// /member/event.do
//	@GetMapping("member/event.do")
//	public void event() {
//		
//	}
	
	@GetMapping("/save.do")
	public String save(HttpServletRequest req, Model model) {
		
		//request 저장
		req.setAttribute("name", "홍길동");
		model.addAttribute("email","hong@gmail.com");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/member/save");
		mav.addObject("id","hong");
		
		// session 저장
		HttpSession sess = req.getSession();
		Map<String, Object> map = new HashMap<>();
		map.put("name", "이순신");
		map.put("age", 40);
		map.put("id", "");
		sess.setAttribute("login",map);
		
		return "/member/save";
	}

}
