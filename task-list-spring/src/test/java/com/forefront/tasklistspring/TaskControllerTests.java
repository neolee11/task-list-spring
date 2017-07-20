package com.forefront.tasklistspring;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import com.forefront.tasklistspring.controller.TaskController;
import com.forefront.tasklistspring.service.TaskService;

public class TaskControllerTests {

	@InjectMocks
	TaskController taskController;
	
	@Mock
	private TaskService taskService;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetAllTasks() {
		
		when(taskService.GetAllTasks()).thenReturn(new ArrayList<>());
		
		Model model = new ExtendedModelMap();
		String result = taskController.getAllTasks(model);
		
		assertThat(result, is("taskList/taskList"));
		assertThat(model.containsAttribute("tasks"), is(true));
		assertThat(model.containsAttribute("newTask"), is(true));
	}

}
