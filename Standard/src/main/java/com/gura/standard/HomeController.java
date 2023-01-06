package com.gura.standard;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("날씨가 많이 추워졌네요.");
		noticeList.add("어쩌구");
		noticeList.add("저쩌구");
		
		//Model을 request scope에 특정 key값으로 담는다.
		request.setAttribute("noticeList",noticeList);
		return "home";
	}
	
}
