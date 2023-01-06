package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.auto.MyCar;

/*
 * 어떤 객체를 spring이 생성해서 관리할지 설정 (bean설정)
 */
/*
 * @Bean annotaion과 함께 MyCar type을 리턴하는 메소드를 미리 만들어 놓으면
 * MyCar type객체가 spring이 관리하는 bean이 된다.
 */
@Configuration
public class JavaConfig {
	
	//이 메소드에서 리턴되는 객체를 spring이 관리하는 bean이 되도록 한다.
	@Bean
	public MyCar myCar() {
		System.out.println("myCar 메소드 호출됨");
		
		MyCar c1 = new MyCar();
		return c1;
	}
}
