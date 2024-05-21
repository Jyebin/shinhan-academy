package chapter12;

import lombok.Data;

@Data
public class MemberVO {
	private int no;
	private String id;
	private String pwd;
	private String name;
	private String[] hobbyName;
	private String filename_org;
	private String filename_real;
}
