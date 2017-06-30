package com.forefront.tasklistspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forefront.tasklistspring.model.Step;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.model.UpdateStepDto;
import com.forefront.tasklistspring.repository.TaskRepository;

@Service
public class TaskService {

	private List<Task> tasks = new ArrayList<>();
	
	@Autowired
	private TaskRepository repo;

	public TaskService() {
		Task task1 = new Task("Task 1");
		task1.setId(1L);
		task1.AddStep(new Step("step 1"));
		task1.AddStep(new Step("step 2"));

		Task task2 = new Task("Task 2");
		task2.setId(2L);
		task2.AddStep(new Step("do this"));
		task2.AddStep(new Step("do that"));
		
		tasks.add(task1);
		tasks.add(task2);
	}

	/*
	 * Task
	 */
	public List<Task> GetAllTasks() {
		return tasks;
	}
	
	public Task AddNewTask(String taskName){
		Task task = new Task(taskName);
		task.setId(100L);
		return this.tasks.add(task) ? task : null;
	}
	
	public Task GetTaskById(long id){
		for(Task t : this.tasks){
			if(t.getId() == id) return t;
		}
		return null;
	}
	
	public Task UpdateTaskNameById(long id, String newName){
		for(Task t : this.tasks){
			if(t.getId() == id){
				t.setName(newName);
				return t;
			}
		}
		return null;
	}
	
	/*
	 * Step
	 */
	public Task AddNewStep(long taskId, String stepContent){
		Task task = GetTaskById(taskId);
		if(task == null) return null;
		
		task.AddStep(new Step(stepContent));
		
		return task;
	}
	
	public Step EditStep(long taskId, UpdateStepDto updatedStep){
		Task task = GetTaskById(taskId);
		if(task == null) return null;
		
		return null;
	}
}
