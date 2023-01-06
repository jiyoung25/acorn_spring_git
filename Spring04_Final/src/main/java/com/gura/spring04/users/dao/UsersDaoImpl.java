package com.gura.spring04.users.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring04.users.dto.UsersDto;

@Repository
public class UsersDaoImpl implements UsersDao {
	
	@Autowired
	private SqlSession session;
	
	@Override
	public boolean isExist(String inputId) {
		boolean isExist = true;
		UsersDto dto = session.selectOne("users.getData",inputId);
		if(dto==null) {
			isExist = false;
		}
		return isExist;
	}

	@Override
	public void insert(UsersDto dto) {
		session.insert("users.insert", dto);
	}

	@Override
	public UsersDto getData(String id) {
		
		/*
		 * mapper's namespace => users
		 * sql'sid => getData
		 * parameterType => String
		 * selectOnt() method를 호출한 경우 resultType이 메소드의 return type이 된다.
		 * resultType = UsersDto
		 * 
		 */
		
		UsersDto dto = session.selectOne("users.getData", id);
		
		return dto;
	}

	@Override
	public void updatePwd(UsersDto dto) {
		session.update("users.updatePwd", dto);
	}

	@Override
	public void update(UsersDto dto) {
		session.update("users.update", dto);
	}

	@Override
	public void delete(String id) {
		session.delete("users.delete", id);
	}

}
