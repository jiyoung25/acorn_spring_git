package com.gura.spring03.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/*
 * [인터셉터 만들기]
 * 
 * 1. HandlerInterceptor인터페이스를 구현한다.
 * 2. servlet-context.xml에 bean을 설정하고 interceptor 목록에 등록을 하고 맵핑을 해준다.
 */

public class MyInterceptor implements HandlerInterceptor {

	//Controller 실행 이전에 호출되는 method
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		/*
		 * true를 리턴하면 계속 흐름을 이어가고, false를 리턴하면 이어가지 않는다.
		 * 다시 말해, false를 리턴하면 play화면에는 preHandle이후의 내용은 아무것도 호출되지 않는다.
		 * (빈 화면이 출력된다.)
		 */
		System.out.println("preHandle");
		return true;
	}
	
	//Controller 실행 이후에 호출되는 method
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
	}
	
	//응답된 이후에 호출되는 메소드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
	}

}
