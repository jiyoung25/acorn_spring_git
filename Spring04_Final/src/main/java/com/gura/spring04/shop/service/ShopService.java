package com.gura.spring04.shop.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public interface ShopService {
	//품목 목록을 ModelAndView객체에 담아주는 메소드.
	public void getList(ModelAndView mView);
	//상품 주문을 처리하는 메소드
	public void buy(HttpServletRequest request, ModelAndView mView);
}
