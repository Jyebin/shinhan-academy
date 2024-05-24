package kr.co.project.reply;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReplyController {

	@Autowired
	private ReplyService service;

	@GetMapping("/reply/index.do")
	public String index(Model model, ReplyVO vo) {
		model.addAttribute("map", service.list(vo));
		return "reply/index";
	}
}
