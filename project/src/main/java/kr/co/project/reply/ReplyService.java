package kr.co.project.reply;

import java.util.Map;

public interface ReplyService {
	int insert(ReplyVO vo);
	int reply(ReplyVO vo); //답변은 다른 트랜잭션이라 따로 처리해 주어야 함
	int update(ReplyVO vo);
	int delete(int no);
	Map<String, Object> list(ReplyVO vo);
	ReplyVO detail(ReplyVO vo, boolean isUpdate); //isUpdate에 true가 들어 있으면 increase readCnt를 실행
}
