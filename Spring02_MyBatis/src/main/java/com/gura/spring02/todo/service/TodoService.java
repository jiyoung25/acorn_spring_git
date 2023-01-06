package com.gura.spring02.todo.service;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.todo.dto.TodoDto;

public interface TodoService {
	public void insertTodo(TodoDto dto);
	public void updateTodo(TodoDto dto);
	public void deleteTodo(int num);
	public void getTodoOne(int num, ModelAndView mView);
	public void getTodoList(ModelAndView mView);
	
	
}
