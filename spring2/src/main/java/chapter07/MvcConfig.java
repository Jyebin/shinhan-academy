package chapter07;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "chapter07")
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

	// HikariCP(Connection Pool)
	@Bean
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/testuser");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

	// MyBatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // CP 객체 주입
		// xml 파일(Mapper 파일) 위치 (경로)
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		ssf.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml")); // 파일이 중첩되어도 들고
		return ssf.getObject();
	}

	// DAO에서 주입 받을 객체
	@Bean
	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
		return new SqlSessionTemplate(sqlSessionFactory()); // MyBatis 객체(빈)를 주입
	}

}