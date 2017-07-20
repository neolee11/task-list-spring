package com.forefront.tasklistspring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.forefront.tasklistspring.model.Step;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.model.TaskNewNameDto;
import com.forefront.tasklistspring.model.UpdateStepDto;
import com.forefront.tasklistspring.service.TaskService;
import com.google.common.base.Strings;

//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/

@RestController
public class TaskApiController {

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/api/tasks", method = RequestMethod.GET)
	public ResponseEntity<List<Task>> GetAllTasks() throws Exception {
		List<Task> allTasks = this.taskService.GetAllTasks();
		return new ResponseEntity<List<Task>>(allTasks, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/api/tasks/{taskId}/rename", method = RequestMethod.POST)
	public ResponseEntity<?> RenameTaskTitle(@PathVariable long taskId, @RequestBody TaskNewNameDto newNameDto) throws Exception {

		
		MultiValueMap<String,String> headers = new LinkedMultiValueMap<String, String>();
		
		if (newNameDto == null) {
//			headers.add("Error", "No data in the request body");	
//			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
			BadRequestError badRequestError = new BadRequestError("No data in the request body");
			return new ResponseEntity<>(badRequestError, HttpStatus.BAD_REQUEST); 
		}
		
		if(Strings.isNullOrEmpty(newNameDto.newName)){
			headers.add("Error", "New task name can not be empty");
//			throw new Exception("bad things");
			
			BadRequestError badRequestError = new BadRequestError("New task name can not be empty");
			return new ResponseEntity<>(badRequestError, HttpStatus.BAD_REQUEST); 
			
//			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
		}

		Task task = this.taskService.UpdateTaskNameById(taskId, newNameDto.newName);
		
		if(task != null){
			return new ResponseEntity<Task>(task, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Task>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/api/tasks/{taskId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteTask(@PathVariable long taskId) throws Exception {

		boolean success = this.taskService.DeleteTask(taskId);

		if(success){
			return new ResponseEntity<Boolean>(success, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Step>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/api/tasks/{taskId}/updateStep", method = RequestMethod.POST)
	public ResponseEntity<?> EditTaskStep(@PathVariable long taskId, @RequestBody UpdateStepDto updatedStepDto) throws Exception {

		if (updatedStepDto == null) {
			BadRequestError badRequestError = new BadRequestError("No data in the request body");
			return new ResponseEntity<>(badRequestError, HttpStatus.BAD_REQUEST); 
		}
		
		Step step = this.taskService.UpdateStep(updatedStepDto);
		
		if(step != null){
			return new ResponseEntity<Step>(step, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Step>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value = "/api/tasks/{taskId}/{stepId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> DeleteStep(@PathVariable long taskId, @PathVariable long stepId) throws Exception {

		boolean success = this.taskService.DeleteStep(stepId);

		if(success){
			return new ResponseEntity<Boolean>(success, HttpStatus.OK);
		}
		else{
			return new ResponseEntity<Step>(HttpStatus.NOT_FOUND);
		}
	}
	
	
}
