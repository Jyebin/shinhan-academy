package chapter06.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import chapter06.excer.Calculator;
import chapter06.excer.CalculatorImpl;
import chapter06.excer.CalculatorImpl2;
import chapter06.excer.TimerAdvice;

@Configuration
@EnableAspectJAutoProxy //aop를 사용하겠다고 enable 시켜야 함
public class BeanConfig {
	@Bean
	public Calculator calculator() {
		return new CalculatorImpl2();
	}
	@Bean
	public TimerAdvice timerAdvice() {
		return new TimerAdvice();
	}
}
