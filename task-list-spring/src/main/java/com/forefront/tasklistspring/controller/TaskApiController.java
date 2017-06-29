package com.forefront.tasklistspring.controller;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

import com.forefront.tasklistspring.model.ErrorRequest;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.model.TaskNewNameDto;
import com.forefront.tasklistspring.service.TaskService;
import com.google.common.base.Strings;

//http://websystique.com/springmvc/spring-mvc-4-restful-web-services-crud-example-resttemplate/

@RestController
public class TaskApiController {

	@Autowired
	private TaskService taskService;

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
}
