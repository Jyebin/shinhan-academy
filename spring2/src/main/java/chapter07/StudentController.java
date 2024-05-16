package chapter07;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	
	@GetMapping("/student/index.do")
	public String index(Model model, StudentVO vo) {
		System.out.println(Arrays.toString(vo.getSearchMajor()));
		List<StudentVO> list = service.all(vo);
		model.addAttribute("list", list);
		return "student/index";
	}
	@GetMapping("/student/view.do")
	public String view(Model model, int studno) {
		System.out.println(studno);
		StudentVO vo = service.view(studno);
		model.addAttribute("vo", vo);
		return "student/view";
	}
	
	@GetMapping("/student/index2.do")
	public String index2(Model model, @RequestParam Map map, HttpServletRequest req) {
		System.out.println(map);
		map.put("searchMajor", req.getParameterValues("searchMajor"));
		List<Map<String, Object>> list = service.all2(map);
		System.out.println(list);
		model.addAttribute("list", list);
		return "student/index";
	}
	
}
