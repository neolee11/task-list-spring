package com.forefront.tasklistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping("/greeting")
	public String sayHello(Model model){
		model.addAttribute("name", "Daniel");
		return "greeting";
	}
	
}
