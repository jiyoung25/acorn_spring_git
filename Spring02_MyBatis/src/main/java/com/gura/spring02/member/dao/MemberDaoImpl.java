package com.gura.spring02.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gura.spring02.member.dto.MemberDto;

//component scan을 통해서 spring이 관리하는 bean이 될 수 있도록 annotation 붙여놓기
@Repository
public class MemberDaoImpl implements MemberDao {
	
	//spring bean container로부터 dependency injection
	@Autowired
	private SqlSession session; //select, insert, update, delete작업을 하기 위한 핵심 의존 객체

	@Override
	public void insert(MemberDto dto) {
		/*
		 * mapper's namespace => member
		 * sql's id => insert
		 * parameterType = MemberDto
		 */
		//insert시 필요한 객체도 전달해주어야 한다. dto: object type이므로 전달 가능
		//dto는 parameter로 전달된다. (MemberMapper에서 parameterType을 지정해줘야 한다.
		session.insert("member.insert", dto);
	}

	@Override
	public void update(MemberDto dto) {
		/*
		 * mapper's namespace => member
		 * sql's id =>update
		 * parameterType = MemberDto
		 */
		session.update("member.update", dto);
	}

	@Override
	public void delete(int num) {
		session.delete("member.delete", num);
	}

	@Override
	public MemberDto getData(int num) {
		/*
		 * mapper's namespace => member
		 * sql's id => getData
		 * resultType=>MemberDto
		 * return type => MemberDto
		 */
		
		/*
		 * selectOnt()메소드를 호출하면 resultType이 MemberDto가고 이 result Type이 return되어야 한다.
		 */
		MemberDto dto = session.selectOne("member.getData", num);
		
		return dto;
	}

	@Override
	public List<MemberDto> getList() {
		/*
		 * mapper's namespace => member
		 * sql's id => getList
		 * resultType=>MemberDto
		 * return type => List
		 */
		/*
		 * selectList()메소드를 호출하면 List가  return type이고 mapper xml의 resultType이 바로
		 * List의 generic type이다.
		 */
		List<MemberDto> list = session.selectList("member.getList");
		
		return list;
	}

}
