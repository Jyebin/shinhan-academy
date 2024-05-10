package chapter05;

import lombok.Data;

@Data //나중에 jpa에서는 사용하면 안됨
public class MemberVO {
	private String id;
	private int age;
}
