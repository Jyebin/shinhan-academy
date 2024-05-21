package chapter11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class NomalController {
	
	@ResponseBody //json으로 응답할 수 있게 해 주는 어노테이션. json 기반의 http body를 자바 객체로 변환
	@GetMapping("/member/index.do")
	public MemberVO index() {
		MemberVO vo = new MemberVO();
		vo.setNo(1);
		vo.setName("홍길동");
		vo.setId("hong");
		return vo;
	} 
	//객체를 그대로 return해 줘도 결과가 같음
	//일반 controller에 json으로 응답하고 싶으면 사용하면 됨
	
}