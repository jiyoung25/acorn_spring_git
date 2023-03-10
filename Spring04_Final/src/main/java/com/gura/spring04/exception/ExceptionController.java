package com.gura.spring04.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/*
 * Spring MVC가 동작 중에 특정 type의 예외가 발생하면 해당 예외를 여기서 처리할 수 있다.
 */
@ControllerAdvice
public class ExceptionController {
	@ExceptionHandler(NotDeleteException.class)
	public ModelAndView notDelete(NotDeleteException nde) {
		ModelAndView mView = new ModelAndView();
		//exception이라는 키값으로 예외 객체를 담고
		mView.addObject("exception", nde);
		//view Page (/WEB-INF/views/error/info.jsp)로 forward이동해서 예외 정보에 응답하기
		mView.setViewName("error/info");
		return mView;
	}
	
	@ExceptionHandler(DeliveryException.class)
	public ModelAndView delivery(DeliveryException de) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception",de);
		mView.addObject("info", "내년부터는 제주도도 배송이 가능하도록 노력하겠습니다.");
		mView.setViewName("error/delivery");
		return mView;
	}
	
	//DB관련 작업을 하다가 발생하는 모든 예외를 처리하는 컨트롤러
	@ExceptionHandler(DataAccessException.class)
	public ModelAndView dataAccess(DataAccessException dae) {
		ModelAndView mView=new ModelAndView();
		mView.addObject("exception",dae);
		mView.setViewName("error/info");
		return mView;
	}
}
