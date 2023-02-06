package com.gura.boot07.todo.Dao;

import java.util.List;

import com.gura.boot07.todo.Dto.TodoDto;

public interface TodoDao {

	public List<TodoDto> getList();
	public void insert(String content);
	public void delete(int num);
}
