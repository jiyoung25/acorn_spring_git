package com.gura.spring04.shop.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.exception.DeliveryException;
import com.gura.spring04.shop.dao.OrderDao;
import com.gura.spring04.shop.dao.ShopDao;
import com.gura.spring04.shop.dto.OrderDto;
import com.gura.spring04.shop.dto.ShopDto;

@Service
public class ShopServiceImpl implements ShopService {
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private OrderDao orderDao;

	@Override
	public void getList(ModelAndView mView) {
		//상품 목록
		List<ShopDto> list = shopDao.getList();
		//ModelAndView객체에 list라는 키값으로 담는다.
		mView.addObject("list",list);
	}

	/*
	 * -Spring Boot transaction 설정 방법
	 *    (1. pom.xml에 spring-tx dependency 추가하기
	 *     2. servlet-context.xml에 transaction설정 추가하기)
	 *     spring boot에선 spring legacy와는 달리 1과 2 과정이 필요 없다.
	 *     
	 * 3. transaction을 관리할 서비스의 메소드에 @Transactional annotation 붙이기
	 * 
	 * - 프로그래머의 의도 하에서 transaction에 영향을 주는 Exception을 발생시키는 방법
	 * DataAccessException Class를 상속받은 Class를 정의하고 (ex) class MyException extends DataAccessException{ } throw new MyException("예외 메시지");
	 * 예외를 발생시킬 조건이라면 위와 같이 예외를 발생시켜서 transaction이 관리되도록 한다.
	 */
	@Transactional
	@Override
	public void buy(HttpServletRequest request, ModelAndView mView) {
		//구입자의 아이디
		String id = (String)request.getSession().getAttribute("id");
		//1. 파라미터로 전달되는 구입할 상품의 번호
		int num = Integer.parseInt(request.getParameter("num"));
		//2. 상품의 가격을 얻어온다.
		int price = shopDao.getPrice(num);
		//3. 상품의 가격만큼 계좌 잔액을 줄인다.
		ShopDto dto = new ShopDto();
		dto.setId(id);
		dto.setPrice(price);
		shopDao.minusMoney(dto);
		//4.가격의 10%를 포인트로 적립한다.
		shopDao.plusPoint(dto);
		//5. 재고의 갯수를 1 줄인다.
		shopDao.minusCount(num);
		//6. 주문 테이블(배송)에 정보를 추가한다.
		OrderDto dto2 = new OrderDto();
		dto2.setId(id);
		dto2.setCode(num);
		//클라이언트가 입력한 배송 주소라고 가정
		String addr = "제주도 강남구 삼원타워";
		
		//가상의 테스트
		if(addr.contains("제주도")) {
			throw new DeliveryException("제주도는 배송이 불가한 지역입니다.");
		}
		dto2.setAddr(addr);
		orderDao.addOrder(dto2);
	}
}
