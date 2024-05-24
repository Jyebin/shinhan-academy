package kr.co.project.reply;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReplyMapper {
	int insert(ReplyVO vo);
	int updateGno(int no);
	int updateOno(ReplyVO vo);
	int update(ReplyVO vo);
	int delete(int no);
	List<ReplyVO> list(ReplyVO vo);
	int count(ReplyVO vo);
	ReplyVO detail(ReplyVO vo);
	int increaseReadcnt(int no);
	
}
