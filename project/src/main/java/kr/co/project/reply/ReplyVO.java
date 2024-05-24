package kr.co.project.reply;

import java.sql.Timestamp;
import lombok.Data;

@Data
public class ReplyVO {
	private int no;
	private String title;
	private String content;
	private Timestamp regdate;
	private int readcnt;
	private int gno;
	private int ono;
	private int nested;
	private int writer;

	// 사용자로부터 전송되어지는 값(검색, 필터링(조건), 페이징 처리 시 사용)
	private String searchType;
	private String searchWord;
	private int page; // 사용자가 요청한 페이지 번호
	private int startIdx; // limit 앞에 들어갈 시작 인덱스값

	public ReplyVO() {
		this.page = 1; //처음 페이지 접속 시 초기값
	}

	public int getStartIdx() {
		return (page - 1) * 10; // 페이지가 1부터 시작하기 때문에 1을 빼줌
	}
}