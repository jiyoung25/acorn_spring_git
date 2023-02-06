package com.gura.boot07.todoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gura.boot07.todo.Dao.TodoDao;
import com.gura.boot07.todo.Dto.TodoDto;

/*
 * Spring 5.0부터 추가된 RestController Annotation을 붙이면
 * JSON 문자열을 응답할 때 @ResponseBody를 생략할 수 있다.
 */

@RestController
public class TodoController {
	
	@Autowired
	private TodoDao dao;
	
	@RequestMapping("/api/todo/list")
	public List<TodoDto> list(){
		return dao.getList();
	}
	
	@RequestMapping("/api/todo/insert")
	public void insert(String content){
		dao.insert(content);
	}
	
	@RequestMapping("/api/todo/delete")
	public void delete(int num){
		dao.delete(num);
	}
}
