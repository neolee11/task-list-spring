package com.forefront.tasklistspring.controller;

public class BadRequestError {
	
	public String error;

	public BadRequestError(String err) {
		this.error = err;
	}
  
}