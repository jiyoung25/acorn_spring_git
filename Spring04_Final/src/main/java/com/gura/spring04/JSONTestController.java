package com.gura.spring04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.spring04.users.dto.UsersDto;

/*
 * 1. jackson-databind 라이브러리가 dependency에 명시되어있고,
 * 2. servlet-context.xml에 <annotation-driven/>이 명시되어 있고,
 * 3. controller의 method에 @ResponseBody annotation이 붙어있으면
 * Map or dto or List 객체에 담긴 내용이 json문자열로 변환되어 응답된다.
 */

@Controller
public class JSONTestController {
	
	@ResponseBody //controller에서 return한 문자열을 그대로 클라이언트에게 출력하는 기능을 가진 annotation
	@RequestMapping("/get_msg")
	public String getMsg() {
		return "hello"; //@ResponseBody를 사용하면 "hello"라는 문자열이 /get_msg경로로 들어온다.
	}
	
	@ResponseBody 
	@RequestMapping("/get_person")
	public Map<String, Object> get_person() {
		
		Map<String, Object> map = new HashMap<>();
		map.put("num", 1);
		map.put("name", "김구라");
		map.put("isMan", true);
		return map; //Map에 담긴 내용이 자동으로 json으로 변환되어 응답됨 (Object type으로 저장)
	}
	
	@ResponseBody 
	@RequestMapping("/get_user")
	public UsersDto getUser() {
		UsersDto dto = new UsersDto();
		dto.setId("gura");
		dto.setPwd("1234");
		dto.setEmail("!");
		
		return dto; //dto에 담긴 내용이 자동으로 json으로 변환되어 응답됨 (Object type으로 저장)(key값은 필드명으로, value를 담지 않으면 null로)
	}
	
	@ResponseBody 
	@RequestMapping("/get_friends")
	public List<String> getFriends() {
		List<String> list = new ArrayList<>();
		list.add("김구라");
		list.add("원숭이");
		list.add("해골");
		
		return list; //dto에 담긴 내용이 자동으로 json으로 변환되어 응답됨 (Array type으로 저장)(key값은 필드명으로, value를 담지 않으면 null로)
	}
	
	@ResponseBody 
	@RequestMapping("/get_users")
	public List<UsersDto> getUsers() {
		List<UsersDto> list = new ArrayList<>();
		
		UsersDto dto1 = new UsersDto();
		dto1.setId("gura");
		dto1.setPwd("1234");
		dto1.setEmail("bb@");
		
		UsersDto dto2 = new UsersDto();
		dto2.setId("monkey");
		dto2.setPwd("4567");
		dto2.setEmail("aa@");
		
		list.add(dto1);
		list.add(dto2);
		
		return list;
	}
}

