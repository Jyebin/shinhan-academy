package chapter06;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogginAdvice implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("[메소드 호출 전 : LogginAdvice");
		System.out.println(invocation.getMethod() + "메소드 호출 전");
		Object object = invocation.proceed();
		System.out.println("[메소드 호출 후 : logginAdvice");
		System.out.println(invocation.getMethod() + "메소드 호출 후");
		return object;
	}

}
