package chapter11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = {"http://127.0.0.1:5502"})
@RestController
public class ApiController {

	@GetMapping("/api/index")
	public String index() {
		return "api";
	}

	@GetMapping("/api/index2")
	public List<MemberVO> index2() {
		MemberVO vo = new MemberVO();
		vo.setNo(1);
		vo.setName("홍길동");
		vo.setId("hong");
		List<MemberVO> list = new ArrayList<>();
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		list.add(vo);
		Map<String, Object> map = new HashMap<>();
		map.put("items", list);
		map.put("display", 5);
		map.put("total", 5);
		return list;
	}

	// /api/index3?id=hong&name=홍길동
	@GetMapping("/api/index3")
	public MemberVO index3(MemberVO vo) {
		return vo;
	}
	
	//파라미터를 받는 방법 (JSON 데이터)
	//body로 넘어오기 때문에 queryString으로 접속할 수 있는 것이 아님
	@PutMapping("/api/index4") //body로 전송 가능
	public MemberVO index4(@RequestBody MemberVO vo) { //객체에 그대로 담김
		vo.setNickName("길똥");
		return vo;
	}

	@GetMapping("/api/index5")
	//http entity를 상속받음. http 응답의 전체 구조를 나타내는 데 사용됨
	//상태 코드를 직접 제어할 수 있음
	public ResponseEntity<MemberVO> index5(){
		MemberVO vo = new MemberVO();
		vo.setName("이순신");
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(vo); //200
	}
	
	@Autowired
	private StudentMapper mapper;
	
	@GetMapping("/api/index6")
	public ResponseEntity<ResponseObject> index6(){
		ResponseObject ro = new ResponseObject();
		ro.setTotal(999);
		ro.setDisplay(10);
		ro.setItems(mapper.itemList());
		return ResponseEntity.status(HttpStatus.OK).body(ro);
	}
}
