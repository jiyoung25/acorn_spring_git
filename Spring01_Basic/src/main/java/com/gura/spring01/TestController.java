package com.gura.spring01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring01.RemoconService;



@Controller
public class TestController {
	
	@Autowired // spring bean container에 RemoconService type의 객체가 있으면 자동 주입이 된다. (DI)
	private RemoconService service; //RemoconServiceImpl 객체의 참조값을 주입받을 필드.
	//RemoconServiceImple이 import되어 있으면 안된다!
	
	@RequestMapping("/move/test")
	public String test() {
		
		/*
		 * Controller 메소드에서 return type을 String으로 설정한 후
		 * 문자열을 리턴해주면 해당 문자열은 view page(jsp)페이지의 위치가 된다.
		 * 즉, 해당 jsp페이지로 자동 forward로 이동되어서 응답하게 된다.
		 */
		
		return "move/test";
	}
	
	@RequestMapping("/move/update")
	public String update() {
		//무언갈 수정했다고 가정하자.
		System.out.println("무언가 수정했습니다.");
		
		//클라이언트에게 새로운 경로로 요청을 다시 하라고 강요하기
		//"redirect:리다일렉트 이동할 상대 경로(context path는 쓰지 않는다.)
		return "redirect:/move/test";
	}
	
	@RequestMapping("/move/fortune")
	public ModelAndView fortune() {
		//Model과 view page의 위치를 동시에 담을 수 있는 Model And View객체를 생성한다.
		ModelAndView mView = new ModelAndView();
		
		//view page에 전달할 모델(data)라고 가정하자.
		String fortuneToday = "동쪽으로 가면 귀인을 만나요.";
		
		//HtpServletRequest객체에 담는 대신에 .addObject(key,Value) 형태로 Model And View객체에 담으면 된다.
		mView.addObject("fortuneToday", fortuneToday);
		
		//view page의 위치를 담는다.
		mView.setViewName("move/fortune");
		
		//리턴해주기
		return mView;
	}
	
	@RequestMapping("/move/fortune2")
	public ModelAndView fortune2(ModelAndView mView) {
		//Model과 view page의 위치를 동시에 담을 수 있는 Model And View객체를 생성한다.
		//new하는 대신에 인자로 전달함
		
		//view page에 전달할 모델(data)라고 가정하자.
		String fortuneToday = "서쪽으로 가면 똥을 만나요.";
		
		//HtpServletRequest객체에 담는 대신에 .addObject(key,Value) 형태로 Model And View객체에 담으면 된다.
		mView.addObject("fortuneToday", fortuneToday);
		
		//view page의 위치를 담는다.
		mView.setViewName("move/fortune2");
		
		//리턴해주기
		return mView;
	}
	
	@RequestMapping("/move/fortune3")
	public ModelAndView fortune3() {
		//Model과 view page의 위치를 동시에 담을 수 있는 Model And View객체를 생성한다.
		//view page의 정보를 객체의 생성시에 바로 전달할 수 있다.
		ModelAndView mView = new ModelAndView("move/fortune3");
		
		//view page에 전달할 모델(data)라고 가정하자.
		String fortuneToday = "북쪽으로 가면 고양이를 만나요.";
		
		//HtpServletRequest객체에 담는 대신에 .addObject(key,Value) 형태로 Model And View객체에 담으면 된다.
		mView.addObject("fortuneToday", fortuneToday);
		
		//view page의 위치를 담는다.
		//setViewName이 필요 없다. 생성자로 전달했기 때문에.
		
		//리턴해주기
		return mView;
	}
	
	@RequestMapping("/di/test")
	public String diTest() {
		
		return "di/test";
	}
	
	@ResponseBody
	@RequestMapping("/di/up")
	public String diUp() {
		/*
		 * 채널을 올리는 로직을 수행할 때 필요한 객체는?
		 */
		//RemoconServiceImpl service = new RemoconServiceImpl();
		//service.up();
		//핵심 객체를 new에서 가져오는 것은 유지보수 면에서 좋지 않다. (객체의 삭제, 수정이 일어나면 error가 나타나 뜯어고쳐야 함)
		
		service.up();
		
		return "up ok!";
	}
	
	@ResponseBody
	@RequestMapping("/di/down")
	public String diDown() {
		service.down();
		
		return "down ok!";
	}
}
