package chapter05;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan(basePackages = "chapter05")
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer {

	// ViewResolver 설정(JSP 경로 설정과 동일). spring 코드만 보면 jsp가 어디 있는지 몰라서 설정 파일을 봐야 함
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	// 정적페이지 처리(컨트롤러가 아니라 톰캣에서 처리하기 위함)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	// 비즈니스 로직이 필요 없는 URL 매핑
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/member/event.do"); // return이 필요 없는 메소드는 url이 그대로 들어감 -> member 폴더 안의 event.jsp가 포워드됨
	}
	// 위의 과정처럼 하지 않으면 아래의 코드를 MemberController에서 정의해주어야 함
	// /member/event.do
	//	@GetMapping("member/event.do")
	//	public void event() {
	//		
	//	}

}