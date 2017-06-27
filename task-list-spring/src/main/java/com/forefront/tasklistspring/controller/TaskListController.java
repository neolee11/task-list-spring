package com.forefront.tasklistspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/tasks")
public class TaskListController {

	@ModelAttribute("moduleName")
	public String moduleName() {
		return "Example";
	}
	
	@RequestMapping(value = "")
	public String getAll(Model model){
		return "taskList/taskList";
	}
	
	@RequestMapping(value = "/{taskId}")
	public String getList(@PathVariable(value="taskId") String id, Model model){
		model.addAttribute("id", id);
		return "taskList/task";
	}
	
}
