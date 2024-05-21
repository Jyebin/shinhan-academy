package chapter11;

import java.util.Date;
import java.util.List;

import lombok.Data;
@Data
public class ResponseObject { //응답을 하기 위한 용도
	private Date lastBuildDate;
	private int display;
	private int total;
	private List items;
	
	public ResponseObject() { //생성자. 객체 초기화
		this.lastBuildDate = new Date();
	}
}
