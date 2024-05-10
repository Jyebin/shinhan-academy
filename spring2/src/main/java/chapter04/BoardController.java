package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BoardController {
	@Autowired

	BoardService service;

	void list() {
		service.list();
	}

}
