package chapter04;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "chapter04") //chapter04부터 살펴서 @component 가 붙은 애들만 등록해줌(시작점 패키지부터 전부 검색)
public class BeanConfig {
	
	
}