package com.gura.boot07.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.gura.boot07.interceptor.LoginInterceptor;
import com.gura.boot07.interceptor.MobileLoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer{
	//로그인 인터셉터 주입 받기
	@Autowired LoginInterceptor loginInterceptor;
	@Autowired MobileLoginInterceptor mLoginInterceptor;
	
	//인터셉터 동작하도록 등록하기
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//Web Browser의 요청에 대해 개입할 Interceptor 등록하기
		registry.addInterceptor(loginInterceptor)
		.addPathPatterns("/users/*","/gallery/*","/cafe/*","/file/*")
		.excludePathPatterns("/users/signup_form", "/users/signup", "/users/loginform", "/users/login",
				"/gallery/list", "/gallery/detail",
				"/cafe/list","/cafe/detail","/cafe/ajax_comment_list",
				"/file/list","/file/download",
				"/gallery/images/*",
				"/users/images/*");
		
		//Mobile요청에 대해 개입할 Interceptor 등록하기
		registry.addInterceptor(mLoginInterceptor)
		.addPathPatterns("/api/gallery/*");
		//.excludePathPatterns("/api/gallery/list","api/gallery/detail");
	}
}











