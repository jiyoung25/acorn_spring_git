package com.gura.spring02.todo.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.todo.dao.TodoDao;
import com.gura.spring02.todo.dto.TodoDto;

@Service
public class TodoServiceImpl implements TodoService {
	
	@Autowired
	TodoDao dao;

	@Override
	public void insertTodo(TodoDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateTodo(TodoDto dto) {
			dao.update(dto);
	}

	@Override
	public void deleteTodo(int num) {
		dao.delete(num);
	}

	@Override
	public void getTodoOne(int num, ModelAndView mView) {
		TodoDto dto = dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void getTodoList(ModelAndView mView) {
		List<TodoDto> list = dao.getList();
		mView.addObject("list", list);
	}
	

}
