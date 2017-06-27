package com.forefront.tasklistspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestApiController {

	@RequestMapping("/api")
	public String home(){
		return "test rest controller";
	}
}
