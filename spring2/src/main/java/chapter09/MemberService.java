package chapter09;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {
	@Autowired
	private MemberMapper mapper;
	// 내가 vo를 생성해야하면 new를 하면 되지만, 대부분의 객체는 bean에 들어가 있기 때문에 주입 해 주면 됨

	@Transactional
	public boolean insert(MemberVO vo) {
		//쇼핑몰 개발 시에도 다음과 같은 로직을 써야 함
		System.out.println("insert 전 : " + vo.getNo()); //insert메소드 실행 전에는 0임
		int result = mapper.insert(vo); // mapper의 insert 메소드 실행. 여기서 currval를 set해줌
		System.out.println("insert 후 : " + vo.getNo()); //방금 insert 한 pk가 들어가 있음
		if (result > 0) {
			//취미 등록
			HobbyVO hvo = new HobbyVO();
			//member 테이블의 pk가 없는데 가져오는 문제
			hvo.setMember_no(vo.getNo());
			for(String name : vo.getHobbyname()) {
				hvo.setName(name);
				mapper.insertHobby(hvo);
			}
			return true;
		}
		return false;
	}
}