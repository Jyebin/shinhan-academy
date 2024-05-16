package chapter08;

import java.util.List;
import java.util.Map;

public interface StudentService {
	List<StudentVO> all(StudentVO vo);
	List<Map<String, Object>> all2(Map<String, Object> vo);
	StudentVO view(int studno);
}
