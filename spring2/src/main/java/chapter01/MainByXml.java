package chapter01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainByXml {

	public static void main(String[] args) {
		// bean 설정파일(xml)을 읽어들임
		// 설정된 설정값으로 bean(객체) 생성 후 container에 저장
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("chapter01/beans.xml");

		// 컨테이너에서 꺼내기(id로 꺼내기)
		Person p = (Person) ctx.getBean("person");
		System.out.println(p);

		// 싱글톤 객체
		Person p2 = (Person) ctx.getBean("person");
		System.out.println(p2);

		Person p3 = ctx.getBean("person", Person.class); // 형변환을 하지 않아도 Person 타입으로 형 변환을 해 줌
		System.out.println(p3);
		
		System.out.println(p3.getName());
		
		Person p4 = ctx.getBean("person2",Person.class);
		System.out.println(p==p4);
	}

}