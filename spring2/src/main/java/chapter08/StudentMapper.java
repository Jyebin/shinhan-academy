package chapter08;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper //원래 어노테이션이 없어도 돌아는 감
// 개발 시 interface가 있는 패키지와 동일한 곳에 동일한 이름으로 mapper.xml을 만들고 interface(mapper file)도 만든 후 <insert id, prameterType ...)을 그대로 만들면 DAO 방식이랑 동일하게 됨
public interface StudentMapper { //틀. 뼈대. 안에 뭐가 들어갔는지보다 어떻게 생겼는지가 더 중요함
	List<StudentVO> all(StudentVO vo);
	StudentVO view(int studno);
}
