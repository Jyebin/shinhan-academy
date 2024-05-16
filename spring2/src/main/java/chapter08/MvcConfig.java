package chapter08;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "chapter08")
@MapperScan(basePackages = "chapter08",annotationClass = Mapper.class)
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	// ViewResolver 설정(JSP 경로)
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	// 정적페이지 처리(컨트롤러가 아니라 톰캣에서 처리하기 위해)
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	// 비즈니스 로직이 필요없는 URL 매핑
	@Override
	public void addViewControllers(ViewControllerRegistry reg) {
		reg.addViewController("/member/event.do");
	}
	// HikariCP
	@Bean
	public HikariDataSource dataSource() {
		HikariDataSource dataSource = new HikariDataSource();
//		dataSource.setDriverClassName("oracle.jdbc.OracleDriver");
//		dataSource.setJdbcUrl("jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setDriverClassName("net.sf.log4jdbc.sql.jdbcapi.DriverSpy");
		dataSource.setJdbcUrl("jdbc:log4jdbc:oracle:thin:@localhost:1521:XE");
		dataSource.setUsername("testuser");
		dataSource.setPassword("test1234");
		return dataSource;
	}
	// MyBatis
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean ssf = new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource()); // CP 객체 주입
		
		// xml 파일(Mapper파일) 위치(경로)
//		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
//		ssf.setMapperLocations(resolver.getResources("classpath:/mapper/**/*.xml"));
		return ssf.getObject();
	}
	// DAO에서 주입받을 객체
//	@Bean
//	public SqlSessionTemplate sqlSessionTemplate() throws Exception {
//		return new SqlSessionTemplate(sqlSessionFactory()); // MyBatis 객체(빈)를 주입
//	}
}
