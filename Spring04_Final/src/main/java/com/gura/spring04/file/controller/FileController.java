package com.gura.spring04.file.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring04.file.dto.FileDto;
import com.gura.spring04.file.service.FileService;
@Controller
public class FileController {
	@Autowired
	private FileService service;
	
	@RequestMapping("/file/list")
	public String list(HttpServletRequest request) {
		service.getList(request);
		
		return "file/list";
	}
	
	@RequestMapping("/file/upload_form")
	public String uploadForm() {
		return "file/upload_form";
	}
	
	@RequestMapping("/file/upload")
	public ModelAndView upload(FileDto dto, ModelAndView mView, HttpServletRequest request) { // dto: title, myFile 담겨있음
		service.saveFile(dto, mView, request);
		mView.setViewName("file/upload");
		
		return mView;
	}
	
	@RequestMapping("/file/download")
	public ModelAndView download(int num, ModelAndView mView) {
		service.getFileData(num, mView);
		//응답할 bean의 이름 설정
		mView.setViewName("fileDownView");
		return mView;
	}
	
	@RequestMapping("/file/delete")
	public ModelAndView delete(int num, ModelAndView mView, HttpServletRequest request) {
		service.deleteFile(num, request);
		mView.setViewName("redirect:/file/list");
		
		return mView;
	}
}
