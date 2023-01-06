package com.gura.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;
import com.gura.spring02.member.service.MemberService;


@Controller
public class MemberController {
	
	//필요한 핵심 의존객체를 얻어온다.
	@Autowired
	private MemberService service;

	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		service.getListMember(mView);
		return mView;
	}
	
	@RequestMapping("/member/insertform")
	public String insertform() {
		//WEB-INF/views/member/insertform.jsp로 forward이동해서 응답하기
		return"member/insertform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) { //폼전송되는 name과 addr이 자동으로 추출되어 MemberDto에 담겨 전달된다.
		
		service.addMember(dto);
		
		return "member/insert";
	}
	
	@RequestMapping("/member/delete")
	public String delete(int num) {
		
		service.deleteMember(num);
		
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(ModelAndView mView, int num) {
		
		service.getMember(num, mView);
		
		return mView;
	}
	
	@RequestMapping("/member/update")
	public String update(MemberDto dto) {
		
		service.updateMember(dto);
		
		return "member/update";
	}
	
}
