package chapter07;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl implements StudentService {
	@Autowired // dao 객체가 필요함. 새 객체를 만들지 않고 autowired로 주입을 받음
	private StudentDAO dao;

	@Override
	public List<StudentVO> all(StudentVO vo) {
		return dao.all(vo);
	}

	@Override
	public List<Map<String, Object>> all2(Map<String, Object> vo) {
		return dao.all2(vo);
	}

	public StudentVO view(int studno) {
		return dao.view(studno);
	}

}