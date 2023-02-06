package com.gura.boot07.todo.Dto;

import org.apache.ibatis.type.Alias;

@Alias("TodoDto")
public class TodoDto {
	private int num;
	private String content;
	private String regdate;
	
	public TodoDto(int num, String content, String regdate) {
		super();
		this.num = num;
		this.content = content;
		this.regdate = regdate;
	}
	
	public TodoDto() {}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

}
