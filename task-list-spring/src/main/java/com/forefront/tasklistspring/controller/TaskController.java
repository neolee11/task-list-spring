package com.forefront.tasklistspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.forefront.tasklistspring.model.NewStepDto;
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
		 NewTaskDto newTaskDto = new NewTaskDto();
		 
		 model.addAttribute("tasks", tasks);
		 model.addAttribute("newTask", newTaskDto);
		return "taskList/taskList";
	}
	
	@RequestMapping(value = "", method=RequestMethod.POST)
	public String handleCreateNewTask(@ModelAttribute @Validated NewTaskDto newTask){
		Task createdTask = this.taskService.AddNewTask(newTask.getTaskName());
		
		if(createdTask != null) {
			return "redirect:/tasks/" + createdTask.getId();
		}
		else{
			return "redirect:/tasks";
		}
	}
	
	@RequestMapping(value = "/{taskId}")
	public String getTask(@PathVariable(value="taskId") long id, Model model){
		Task task = this.taskService.GetTaskById(id);
		NewStepDto newStepDto = new NewStepDto();
		newStepDto.setTaskId(id);
		
		model.addAttribute("task", task);
		model.addAttribute("newStep", newStepDto);
		
		return "taskList/task";
	}
	
	
	@RequestMapping(value = "/{taskId}", method=RequestMethod.POST)
	public String handleCreateNewStep(@PathVariable(value="taskId") long id, @ModelAttribute @Validated NewStepDto newStep){
		Task createdTask = this.taskService.AddNewStep(newStep.getTaskId(), newStep.getStepContent());
		return "redirect:/tasks/" + newStep.getTaskId();
	}
	
}
