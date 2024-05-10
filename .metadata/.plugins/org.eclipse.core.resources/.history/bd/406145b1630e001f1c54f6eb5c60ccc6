package chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainByJava {

	public static void main(String[] args) {
		// 설정파일(자바파일) 읽어들이기
		// 빈(객체) 생성, 컨테이너에 저장
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(javaConfig.class);

		Person p1 = (Person) ctx.getBean("person"); //이름으로 꺼내쓰는거지 메소드를 호출하는 것은 아님
		System.out.println(p1);
		Person p2 = (Person) ctx.getBean("person");
		Person p3 = (Person) ctx.getBean("person");
		Person p4 = (Person) ctx.getBean("person");
	}

}