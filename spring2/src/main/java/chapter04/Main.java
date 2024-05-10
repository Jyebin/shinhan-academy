package chapter04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		BoardController con = ctx.getBean("boardController", BoardController.class);
		con.list();
	}

}
