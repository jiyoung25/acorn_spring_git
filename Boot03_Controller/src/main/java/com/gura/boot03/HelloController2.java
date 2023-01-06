package com.gura.boot03;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//RestController: 기본적으로 @ResponseBody가 내장되어있음
@RestController
public class HelloController2 {
	//GET 방식 /hello2요청을 해오면 "hello2"라는 문자열이 바로 응답된다. (@ResponseBody효과)
	@RequestMapping(method=RequestMethod.GET, value="/hello2")
	public String hello2() {
		return "hello2";
	}
	
	//위의 맵핑 방식을 좀 더 간단하게 할 수 있다.
	@GetMapping("/hello3")
	public String hello3() {
		return "hello3";
	}
}
