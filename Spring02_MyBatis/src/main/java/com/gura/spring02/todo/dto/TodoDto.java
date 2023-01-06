package com.gura.spring02.todo.dto;

import java.sql.Date;

public class TodoDto {
	private int num;
	private String content;
	private String regdate;
	private Date deadline;
	
	public TodoDto() {
		
	}
	
	public TodoDto(int num, String content, String regdate, Date deadline) {
		super();
		this.num = num;
		this.content = content;
		this.regdate = regdate;
		this.deadline = deadline;
	}



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

	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

}
