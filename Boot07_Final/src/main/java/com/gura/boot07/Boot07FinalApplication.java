package com.gura.boot07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.PropertySource;

/*
 *  이 프로젝트로 xxx.war파일을 만들어서 외부 tomcat으로 실행하려면
 *  
 *  1. SpringBootServletInitializer을 상속받아서 설정해야 한다.
 *  
 *  2. pom.xml에 <packaging>war</packaging>추가하고
 *  3. pom.xml dependency 추가
 *      <dependency>
 *          <groupId>org.springframework.boot</groupId>
 *          <artifactId>spring-boot-starter-tomcat</artifactId>
 *          <scope>provided</scope>
 *      </dependency>
 *  4.  
 *     [프로젝트 우클릭] → [Run As]  → [Maven build...]를 차례로 선택한다.
 * *      - Goals에 package를 입력하고, Profiles에 pom.xml을 지워주고, Run 버튼을 클릭한다.
 *      - console에 BUILD SUCCESS가 표시되고, 프로젝트 폴더 안 target 폴더에는 war 파일이 생성되어 있다.
 * *
 *
 */

@SpringBootApplication
@PropertySource("classpath:custom.properties") //resources/custom.properties 로딩하기 
public class Boot07FinalApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Boot07FinalApplication.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		
		return builder.sources(Boot07FinalApplication.class);
	}

}
