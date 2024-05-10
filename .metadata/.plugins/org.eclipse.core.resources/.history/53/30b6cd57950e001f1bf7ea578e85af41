package chapter01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javaConfig {
	//빈 등록(메소드)
	//빈 이름 : 메소드 이름
	@Bean
	public Person person() { //JavaConfig를 읽어들일 때 spring이 이 메소드를 실행
		return new Person();
	}
}
