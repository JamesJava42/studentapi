package com.relation.hibernate.exception;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class Exceptionobject {
	
	String message;
	int code;
	String time;
	
	
	public Exceptionobject(String message, int code, String time) {
		super();
		this.message = message;
		this.code = code;
		this.time = time;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	
	
	public Exceptionobject() {}

}
