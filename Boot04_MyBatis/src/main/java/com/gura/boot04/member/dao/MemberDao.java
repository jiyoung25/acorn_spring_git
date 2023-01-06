package com.gura.boot04.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//테스트이므로 굳이 interface를 만들지 않음
@Repository
public class MemberDao {
	@Autowired
	private SqlSession session;
	
	public List<MemberDto> getList(){
		return session.selectList("member.getList");
	}
}
