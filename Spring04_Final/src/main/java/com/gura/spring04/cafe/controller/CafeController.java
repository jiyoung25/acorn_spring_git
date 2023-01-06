package com.gura.spring04.cafe.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.cafe.dto.CafeCommentDto;
import com.gura.spring04.cafe.dto.CafeDto;
import com.gura.spring04.cafe.service.CafeService;

@Controller
public class CafeController {
	
	@Autowired
	private CafeService cafeService;
	
	@RequestMapping("/cafe/list")
	public String list(HttpServletRequest request) {
		
		cafeService.getList(request);
		return "cafe/list";
	}
	
	@RequestMapping("/cafe/insertform")
	public String insertform() {
		return "cafe/insertform";
	}
	
	@RequestMapping("/cafe/insert")
	public String insert(ModelAndView mView, CafeDto dto) {
		
		cafeService.saveContent(dto);
		mView.setViewName("cafe/insert");
		
		return "cafe/insert";
	}
	
	@RequestMapping("/cafe/detail")
	public String detail(HttpServletRequest request) {
		cafeService.getDetail(request);
		return "cafe/detail";
	}
	
	@RequestMapping("/cafe/updateform")
	public String updateform(HttpServletRequest request) {
		cafeService.getData(request);
		
		return "cafe/updateform";
	}
	
	@RequestMapping("/cafe/update")
	public String update(CafeDto dto) {
		cafeService.updateContent(dto);
		
		return "cafe/update";
	}
	
	@RequestMapping("/cafe/delete")
	public String delete(int num, HttpServletRequest request) {
		cafeService.deleteContent(num, request);
		return "redirect:/cafe/list";
	}

	// 새로운 댓글 저장 요청 처리
	@RequestMapping("/cafe/comment_insert")
	public String commentInsert(HttpServletRequest request, int ref_group) {

		cafeService.saveComment(request);

		return "redirect:/cafe/detail?num=" + ref_group;
	}

	// 댓글 더보기 요청 처리
	@RequestMapping("/cafe/ajax_comment_list")
	public String commentList(HttpServletRequest request) {
		
		//테스트를 위해 시간 지연시키기
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		cafeService.moreCommentList(request);

		return "cafe/ajax_comment_list";
	}

	// 댓글 삭제 요청 처리
	@RequestMapping("/cafe/comment_delete")
	@ResponseBody
	public Map<String, Object> commentDelete(HttpServletRequest request) {
		cafeService.deleteComment(request);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		// {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다.
		return map;
	}

	// 댓글 수정 요청처리 (JSON 을 응답하도록 한다)
	@RequestMapping("/cafe/comment_update")
	@ResponseBody
	public Map<String, Object> commentUpdate(CafeCommentDto dto, HttpServletRequest request) {
		cafeService.updateComment(dto);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("isSuccess", true);
		// {"isSuccess":true} 형식의 JSON 문자열이 응답되도록 한다.
		return map;
	}
}
