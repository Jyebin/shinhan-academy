package chapter09;

import lombok.Data;

@Data
public class MemberVO {
	private int no;
	private String id;
	private String pwd;
	private String name;
	private String[] hobbyname;
}
