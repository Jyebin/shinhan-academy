package chapter07;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDAO {
	@Autowired
	private SqlSessionTemplate sst;
	
	// 전체학생목록 조회 리턴
	public List<StudentVO> all(StudentVO vo) {
		return sst.selectList("student.all", vo);
	}
	public List<Map<String, Object>> all2(Map<String, Object> map) {
		return sst.selectList("student.all2", map);
	}
	public StudentVO view(int studno) {
		return sst.selectOne("student.view", studno);
	}
}
