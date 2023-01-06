package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.demo.auto.Car;
import com.example.demo.auto.LegacyCar;
import com.example.demo.auto.MyCar;

@SpringBootApplication
public class Boot01HelloApplication {
	//Spring Boot Application이 시작되는 main 메소드
	public static void main(String[] args) {
		//springApplication class의 static method run()을 호출하면 ApplicationContext객체가 리턴된다.
		ApplicationContext ctx =  SpringApplication.run(Boot01HelloApplication.class, args);
		//Spring이 관리하는 bean중에서 Car Type을 찾아오기 (객체는 한 번만 생성이 된다.)
		Car car1 = ctx.getBean(Car.class);
		MyCar car2 = ctx.getBean(MyCar.class);
		
		car1.drive();
		car2.drive();
		
		//resources 폴더의 config.xml문서를 로딩해서 bean을 생성해 관리하기 (예전 방식)
		ApplicationContext ctx2 = new ClassPathXmlApplicationContext("config.xml");
		LegacyCar c3 = ctx2.getBean(LegacyCar.class);
		c3.drive();
		
	}

}
