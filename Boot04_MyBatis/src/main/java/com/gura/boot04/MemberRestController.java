package com.gura.boot04;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gura.boot04.member.dao.MemberDao;
import com.gura.boot04.member.dao.MemberDto;

// 1. @RestController를 이용해서 Controller을 만들고
@RestController
public class MemberRestController {
	@Autowired
	private MemberDao dao;
	
	// 2.메소드에서 어떤 data를 리턴하면 리턴되는 데이터가 클라이언트에게 바로 응답된다.
	// String은 내용이 그대로 응답되고, dto, Map, List등은 JSON문자열로 변환되어 응답된다.
	@GetMapping("/member/list")
	public List<MemberDto> list(){
		return dao.getList();
	}
}
