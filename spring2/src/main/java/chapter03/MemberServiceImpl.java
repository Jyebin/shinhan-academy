package chapter03;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberServiceImpl implements MemberService { // 외부에서 MemberDAO 객체를 주입해 주는 코드

	@Autowired //자동 주입(빈에 등록된 객체만 가능)
	MemberDAO dao;
	public void setMemberDAO(MemberDAO dao) {
		this.dao = dao;
	}

	@Override
	public void regist() {
		// MemberDAO dao = new MemberDAO();
		dao.regist();
	}

}
