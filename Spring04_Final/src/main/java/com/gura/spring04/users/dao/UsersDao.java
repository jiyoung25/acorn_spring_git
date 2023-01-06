package com.gura.spring04.users.dao;

import com.gura.spring04.users.dto.UsersDto;

public interface UsersDao {
	public boolean isExist(String inputId); //인자로 전달된 아이디 존재함?
	public void insert(UsersDto dto);
	public UsersDto getData(String id);
	public void updatePwd(UsersDto dto); //비밀번호 수정
	public void update(UsersDto dto); //개인정보 수정
	public void delete(String id);
}
