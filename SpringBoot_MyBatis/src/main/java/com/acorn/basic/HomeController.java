package com.acorn.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/*
 *  [ jsp페이지를 사용하기 위한 설정]
 *  
 *  1. pom.xml에 tomcat-embed-jasper과 jstl dependency를 추가한다
 *  
 *  2. /webapp/WEB-INF/views/ 구조로 폴더를 src/main하위에 만든다.
 *  
 *  3. view page의 prefix와 suffix설정을 application.properties(임시)에 추가한다.
 *   ->spring.mvc.view.prefix=/WEB-INF/views/
 *   ->spring.mvc.view.suffix=.jsp
 *   이 내용을 추가한다. (추후에 설정을 다른 곳에서 해야한다.)
 * 
 */
@Controller
public class HomeController {
	@GetMapping("/")
	public String home(HttpServletRequest request) {
		List<String> noticeList = new ArrayList<>();
		noticeList.add("Spring Boot 시작입니다.");
		noticeList.add("어쩌구 ...");
		noticeList.add("저쩌구 ...");
		request.setAttribute("noticeList", noticeList);
		
		return "home";
	}
	
	@PostMapping("/upload")
	public String upload(HttpServletRequest request, @RequestParam MultipartFile file) {
		//업로드된 파일의 원본 파일명
		String orgFileName = file.getOriginalFilename();
		//파일을 저장할 절대 경로 구성하기
		String realPath = request.getServletContext().getRealPath("/resources/upload")
				+File.separator+System.currentTimeMillis()+orgFileName;
		//해당 파일을 실제로 만들 File 객체
		File upload = new File(realPath);
		if(!upload.exists()) {
			upload.mkdir();
		}
		try {
			String savePath = realPath+File.separator+System.currentTimeMillis()+orgFileName;
			file.transferTo(new File(savePath));
		} catch(Exception e) {
			e.printStackTrace();
		}
		long fileSize = file.getSize();
		
		request.setAttribute("fileName", orgFileName);
		request.setAttribute("fileSize", fileSize);
		
		return "upload";
	}
}
