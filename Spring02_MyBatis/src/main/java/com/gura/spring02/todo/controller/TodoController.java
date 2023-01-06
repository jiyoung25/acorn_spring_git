package com.gura.spring02.todo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.todo.dto.TodoDto;
import com.gura.spring02.todo.service.TodoService;

@Controller
public class TodoController {
	
	@Autowired
	TodoService service;
	
	@RequestMapping("/todo/list")
	public ModelAndView list(ModelAndView mView) {
		
		service.getTodoList(mView);
		
		return mView;
	}
	
	@RequestMapping("/todo/insertform")
	public String insertform() {
		return "todo/insertform";
	}
	
	@RequestMapping("/todo/insert")
	public String insert(TodoDto dto) {
		
		service.insertTodo(dto);

		return "todo/insert";
	}
	
	@RequestMapping("/todo/updateform")
	public ModelAndView updateform(ModelAndView mView, HttpServletRequest request) {
		service.getTodoOne(Integer.parseInt(request.getParameter("num")), mView);
		
		return mView;
	}
	
	@RequestMapping("/todo/update")
	public String update(TodoDto dto) {
		
		service.updateTodo(dto);
		
		return "todo/update";
	}
	
	@RequestMapping("/todo/delete")
	public String delete(int num) {
		service.deleteTodo(num);
		return "redirect:/todo/list";
	}
}
