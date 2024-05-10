package chapter04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import chapter02.MemberService;

@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardDAO dao;

	@Override
	public void list() {
		dao.list();
	}

}
