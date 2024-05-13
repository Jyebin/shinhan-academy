package chapter06.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import chapter06.excer.Calculator;

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeanConfig.class);
		Calculator cal = (Calculator) ctx.getBean("calculator");
		cal.factorial(10);
		long val = cal.factorial(10);
		System.out.println(val);
		System.out.println(cal.getClass().getName());
	}

}
