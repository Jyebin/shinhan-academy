package chapter04;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {
	public void list() {
		System.out.println("게시판 목록");
	}

}
