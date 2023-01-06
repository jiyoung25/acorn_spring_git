package com.gura.boot05;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/*
 *  [ jsp페이지를 사용하기 위한 설정]
 *  
 *  1. pom.xml에 tomcat-embed-jasper과 jstl dependency를 추가한다
 *  
 *  2. /webapp/WEB-INF/views/ 구조로 폴더를 src/main하위에 만든다.
 *  
 *  3. view page의 prefix와 suffix설정을 application.properties(임시)에 추가한다.
 *   ->spring.mvc.view.prefix=/WEB-INF/views/
 *   ->spring.mvc.view.suffix=.jsp
 *   이 내용을 추가한다. (추후에 설정을 다른 곳에서 해야한다.)
 * 
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		List<String> noticeList = new ArrayList<>();
		noticeList.add("Spring Boot 시작입니다.");
		noticeList.add("어쩌구 ...");
		noticeList.add("저쩌구 ...");
		request.setAttribute("noticeList", noticeList);
		
		return "home";
	}
}
