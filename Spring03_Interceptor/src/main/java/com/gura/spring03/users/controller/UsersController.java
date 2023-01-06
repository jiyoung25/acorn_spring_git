package com.gura.spring03.users.controller;

import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsersController {
	//로그인 폼 요청 처리
	@RequestMapping("/users/loginform")
	public ModelAndView loginform(ModelAndView mView, HttpServletRequest request) {
		String encodedUrl = (String) request.getAttribute("encodedUrl");
		System.out.println("loginform: "+encodedUrl);
		if(encodedUrl==null) {
			encodedUrl="/";
		}
		
		String deCodedUrl = URLDecoder.decode(encodedUrl);
		
		mView.addObject("deCodedUrl", deCodedUrl);
		mView.setViewName("users/loginform");
		
		return mView;
	}
	
	//로그인 요청 처리
	@RequestMapping("/users/login")
	public String login(String id, String deCodedUrl, HttpSession session, HttpServletRequest request) {
		
		session.setAttribute("id", id);
		request.setAttribute("deCodedUrl", deCodedUrl);
		System.out.println("login: "+deCodedUrl);
		
		return "users/login";
	}
	
	//로그아웃 요청 처리
	@RequestMapping("/users/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "users/logout";
	}
	
	//개인정보 보기 요청 처리
	@RequestMapping("/users/info")
	public String info() {
		return "users/info";
	}
}
