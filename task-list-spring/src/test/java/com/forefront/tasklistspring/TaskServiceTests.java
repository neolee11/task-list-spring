package com.forefront.tasklistspring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.repository.StepRepository;
import com.forefront.tasklistspring.repository.TaskRepository;
import com.forefront.tasklistspring.service.TaskService;

public class TaskServiceTests {

	
	@InjectMocks
	private TaskService sut;
	
	@Mock
	private TaskRepository taskRepo;

	@Mock
	private StepRepository stepRepo;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetTaskById() {

		Task task = new Task();
		task.setId(1L);
		task.setName("Original Name");
		when(taskRepo.findOne(1L)).thenReturn(task);
		
		Task result = sut.GetTaskById(1L);
		
		verify(taskRepo).findOne(1L);
		
		assertThat(result.getId(), is(1L));
		assertThat(result.getName(), is("Original Name"));
	}
	
	@Test
	public void testUpdateTaskNameById(){
		
		Task task = new Task();
		task.setId(1L);
		task.setName("Original Name");
		when(taskRepo.findOne(1L)).thenReturn(task);
		when(taskRepo.saveAndFlush(task)).thenReturn(task);
		
		Task result = sut.UpdateTaskNameById(1L, "New name");
		assertThat(result.getName(), is("New name"));
	}

}
