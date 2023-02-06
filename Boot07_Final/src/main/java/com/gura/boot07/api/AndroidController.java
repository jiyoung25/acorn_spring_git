package com.gura.boot07.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.boot07.gallery.dao.GalleryDao;
import com.gura.boot07.gallery.dao.GalleryDaoImpl;
import com.gura.boot07.gallery.dto.GalleryDto;
import com.gura.boot07.todo.Dto.TodoDto;

/*
 * 안드로이드의 app의 요청을 처리할 Controller
 */

@Controller
public class AndroidController {	
	@Autowired
	GalleryDao dao;
	
	/*
	 * JSON 문자열 응답하기
	 * 
	 * 1. @ResponseBody annotation 2. Map 혹은 List 혹은 Dto를 리턴하면 자동으로 JSON 문자열로 변환되어서
	 * 응답된다.
	 */
	
	@RequestMapping("/api/send")
	@ResponseBody
	public Map<String, Object> send(String msg) {
		System.out.println(msg);
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);
		map.put("response", "hello client!");
		map.put("num", 1);
		return map;
	}

	@RequestMapping("/api/list")
	@ResponseBody
	public List<String> list(int pageNum) {
		List<String> list = new ArrayList<>();
		list.add("김구라");
		list.add("해골");
		list.add("원숭이");

		return list;
	}

	@RequestMapping("/api/logincheck")
	@ResponseBody
	public Map<String, Object> logincheck(HttpSession session) {
		System.out.println("세션 아이디:" + session.getId());
		Map<String, Object> map = new HashMap<>();
		String id = (String) session.getAttribute("id");

		if (id == null) {
			map.put("isLogin", false);
			System.out.println("로그인중이 아님요");
		} else {
			map.put("isLogin", true);
			map.put("id", id);
			System.out.println(id + " 로그인중...");
		}
		return map;
	}

	@RequestMapping("/api/login")
	@ResponseBody
	public Map<String, Object> login(String id, String pwd, HttpSession session) {
		session.setMaxInactiveInterval(60*60);
		System.out.println(id + "|" + pwd);
		Map<String, Object> map = new HashMap<>();
		if (id.equals("gura") && pwd.equals("1234")) {
			map.put("isSuccess", true);
			map.put("id", id);
			session.setAttribute("id", id);
		} else {
			map.put("isSuccess", false);
		}
		return map;
	}

	@RequestMapping("/api/logout")
	@ResponseBody
	public Map<String, Object> logout(HttpSession session) {
		System.out.println("세션 아이디:" + session.getId());
		session.invalidate();
		Map<String, Object> map = new HashMap<>();
		map.put("isSuccess", true);
		return map;
	}
	
	@RequestMapping("/api/gallery/list")
	@ResponseBody
	public List<GalleryDto> galleryList(){
		//최신 gallery data 10개만 가져오기 위해
		GalleryDto dto = new GalleryDto();
		dto.setStartRowNum(1);
		dto.setEndRowNum(10);
		
		return dao.getList(dto);
	}
}
