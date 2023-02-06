package com.gura.boot07.todo.Dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.boot07.todo.Dto.TodoDto;

@Repository
public class TodoDaoImpl implements TodoDao {
	@Autowired
	private SqlSession session;

	@Override
	public List<TodoDto> getList() {
		return session.selectList("todo.getList");
	}

	@Override
	public void insert(String content) {
		session.insert("todo.insert", content);
	}

	@Override
	public void delete(int num) {
		session.delete("todo.delete", num);		
	}
}
