package chapter12;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	int insert(MemberVO vo);
	int insertHobby(HobbyVO vo);
	int idCheck(String id);
	MemberVO login(MemberVO vo);
	MemberVO mypage(int no);
}