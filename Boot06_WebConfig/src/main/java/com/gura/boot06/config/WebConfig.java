package com.gura.boot06.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gura.boot06.MyInterceptor;

/*
 *  [ Spring MVC 관련 설정 ]
 * 
 *  1. WebMvcConfigurer interface를 구현한다.
 *  
 *  2. 설정에 필요한 메소드만 OVERRIDING한다.
 *   주로, Resource Handler, Interceptor, view page 관련 설정을 여기에서 한다.
 *   
 *  3. 설정에 관련된 클래스에는 @Configuration annotation을 붙여야 한다.
 *  (implements WebMvcConfigurer한 class이외에도 설정에 관련된 class는 모두 @Configuration)
 */

@Configuration
//@EnableWebMvc //스프링이 자동 설정해주는 모든 기능을 사용하기 위해 붙여주어야 한다.
public class WebConfig implements WebMvcConfigurer{
	/*
	 *  Spring Legacy project의 servlet-context.xml에서 설정했던
	 *  web/resources/ 안에 있는 내용을 서비스하기 위한 설정을 Spring Boot에서도 해야 한다.
	 *  ==> Spring Legacy Project: <resources mapping="/resources/**" location="/resources/" />
	 *  
	 *  아래를 설정하면 webapp에 resources폴더를 만들어 놓고 그 안에 들어있는 내용에 대한 요청은
	 *  spring framework를 거치지 않고 바로 응답되게 할 수 있다.
	 *  
	 *  -> 이를 이용해 SmartEditor2 나 프로필 이미지를 저장할 upload 폴더를 만들 예정이다.
	 */
	
	//여기서 bean으로 관리되는 MyInterceptor 객체가 필요하다면..
	@Autowired
	private MyInterceptor inter; //주입받으면 된다!	
		
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(inter).addPathPatterns("/users/*").excludePathPatterns("/users/loginform");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	/*
	 *  view page의 prefix와 suffix 설정
	 *  application.properties에 적어둔 prefix와 suffix는 @EnableWebMvc annotation을 붙임과 동시에
	 *  효력을 상실한다.
	 *  그러므로 여기에 직접 만들어줘야 한다.
	 */
	/*
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}
	현재는 EnableWebMVC를 주석처리 해 놨으므로 위 코드가 없어도 된다.
	*/
	
}
