package com.gura.boot03;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Spring Boot Web은 내장된 tomcat server가 있다. (9버전)
 * 그래서 따로 tomcat server를 잡을 필요가 없다.
 */
@SpringBootApplication
public class Boot03ControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Boot03ControllerApplication.class, args);
	}

}
