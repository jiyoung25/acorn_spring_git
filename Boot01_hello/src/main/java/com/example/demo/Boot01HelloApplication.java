package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Boot01HelloApplication {
	//Spring Boot Application이 시작되는 main 메소드
	public static void main(String[] args) {
		//springApplication class의 static method run()을 호출하면 ApplicationContext객체가 리턴된다.
		ApplicationContext ctx =  SpringApplication.run(Boot01HelloApplication.class, args);
		//Spring이 관리하는 bean중에서 Car Type을 찾아오기 (객체는 한 번만 생성이 된다.)
		Car car1 = ctx.getBean(Car.class);
		Car car2 = ctx.getBean(Car.class);
		
		car1.drive();
		car2.drive();
		
	}

}
