package com.forefront.tasklistspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forefront.tasklistspring.model.NewTaskDto;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.service.TaskService;

@Controller
@RequestMapping(value="/tasks")
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@ModelAttribute("moduleName")
	public String moduleName() {
		return "Example";
	}
	
	@RequestMapping(value = "")
	public String getAllTasks(Model model){
		 List<Task> tasks = taskService.GetAllTasks();
		 model.addAttribute("tasks", tasks);
		return "taskList/taskList";
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public void handleCreateNewTask(@RequestBody NewTaskDto newTask ){
		this.taskService.AddNewTask(newTask.taskName);
	}
	
	@RequestMapping(value = "/{taskId}")
	public String getTask(@PathVariable(value="taskId") String id, Model model){
		model.addAttribute("id", id);
		return "taskList/task";
	}
	
}
