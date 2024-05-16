package chapter09;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	int insert(MemberVO vo);
	int insertHobby(HobbyVO vo);
}