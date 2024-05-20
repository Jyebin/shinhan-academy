package chapter10;

import java.sql.Timestamp;

import lombok.Data;

@Data
public class MemberVO {
	private String no;
	private String name;
	private String pwd;
	private String email;
	private Timestamp joinDate;
	private boolean pass;
	private String[] hobbyName;
}
