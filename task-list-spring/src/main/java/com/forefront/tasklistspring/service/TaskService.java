package com.forefront.tasklistspring.service;

import java.util.ArrayList;
import java.util.List;

import com.forefront.tasklistspring.model.Task;

public class TaskService {

	public Task CreateNewTask(String title){
		return new Task(title);
	}
	
	public List<Task> GetAllTasks(){
		List<Task> tasks = new ArrayList<>();
		return tasks;
	}
}
