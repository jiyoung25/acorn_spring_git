package com.acorn.basic.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//component scan을 통해서 spring이 관리하는 bean이 될 수 있도록 annotation 붙이기
@Repository
public class MemberDaoImpl implements MemberDao {
	@Autowired
	private SqlSession session;
	//application.properties에 설정한 정보가 잘 동작한다면 SqlSession객체가 자동으로 bean설정된다.
}
