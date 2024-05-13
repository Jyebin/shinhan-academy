package chapter06.excer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class TimerAdvice {
	@Pointcut("execution(public * chapter06.excer..*(..))") // 위치를 지정. public에 있는 모든 것, chapter06의 excer에 있는 모든 메소드
	public void timerTarget() {};

	@Around("timerTarget()")
	public Object invoke(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("메소드 실행 전");
		Object obj = joinPoint.proceed(); // 실제 메소드 실행
		System.out.println("메소드 실행 후");
		
		return obj;
	}
}
