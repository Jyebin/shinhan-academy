package chapter09;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String insert(MemberVO vo) { //@ModelAttribute 
		System.out.println(Arrays.toString(vo.getHobbyname()));
		service.insert(vo); // 파라미터를 받아 insert를 호출하는 것이 주 목적
		return "";
	}
}
