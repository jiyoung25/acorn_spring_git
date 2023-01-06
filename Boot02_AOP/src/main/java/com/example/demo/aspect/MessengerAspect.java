package com.example.demo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class MessengerAspect {
   /*
    *  return type 은 String 이고
    *  get 으로 시작은 메소드 이고
    *  메소드에 전달되는 인자는 없다 
    *  java.lang 페키지에 있는 type 은 페키지명 생략 가능
    */
	// com.example.demo.util.*을 생략하면 (다시말해, 패키지 명을 생략하면)오류가 난다.
   @Around("execution(String com.example.demo.util.*.get*())")
   public Object checkReturn(ProceedingJoinPoint joinPoint) throws Throwable {

      // aspect 가 적용된 메소드를 수행하고 리턴되는 데이터 받아오기 
      Object obj=joinPoint.proceed();
      //원래 type 으로 casting 해서 조사해 볼수가 있다.
      String a = (String)obj; //obj는 위에 어노테이션으로 감싸둔 String get*()에서 리턴된 값이다.
      
      //조사후 아예 다른 값을 리턴해줄 수도 있다. 
      return "놀자 놀자!";
   }
   
   @Around("execution(void send*(..))")
   public void checkGreeting(ProceedingJoinPoint joinPoint) throws Throwable{
	   //메소드에 전달된 인자들 목록을 불러오기
	   Object[] args = joinPoint.getArgs();
	   //반복문을 돌면서 원하는 type의 값을 찾아서 작업한다.
	   for(Object tmp:args) {
		   //만일 String type이면
		   if(tmp instanceof String) {
			   //원래의 타입으로 casting한다.
			   String msg = (String)tmp;
			   System.out.println("aspect에서 읽어낸 내용: "+msg);
			   if(msg.contains("바보")){
				   System.out.println("바보는 금지된 단어입니다.");
				   return; //메소드 끝내기
			   }
		   }
	   }
	   
	   //aspect가 적용된 메소드가 호출되기 직전에 할 작업은 여기서 한다.
	   joinPoint.proceed();//aspect가 적용된 메소드 수행하기
	   //aspect가 적용된 메소드가 리턴된 직후에 하 작업은 여기에서 한다.
	   System.out.println("aspect가 적용된 메소드가 리턴되었습니다.");
   }
}


