package chapter12;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
	// interface에 추상메소드가 있으면 하나라도 재정의해야 함 -> 근데 생성 직후에는 안나옴
	// 기본적으로 있는 preHandler, postHandle, afterCompletion을 재정의해야 함
	// preHandle() : 전
	// postHandle() : 후
	// afterCompletion() : 응답 후 -> 혼자만 return이 있음
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		//세션이 없으면 통과를 시키지 않는 로직을 작성해야 함
		//세션 체크 -> 세션을 매개변수로 담을 수 없음 
		HttpSession sess = request.getSession();
		if(sess.getAttribute("login") == null) {
			response.setContentType("text/html;charset-utf-8");
			PrintWriter pw = response.getWriter();
			pw.println("<script>");
			pw.println("alert('로그인 후 이용 가능합니다.');");
			pw.println("location.href='login.do';");
			pw.println("</script>");
			pw.close();
			return false; //통과가 안됨
		}
		return true; //통과가 됨
	}
}
