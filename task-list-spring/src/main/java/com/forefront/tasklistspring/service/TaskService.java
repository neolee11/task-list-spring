package com.forefront.tasklistspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.repository.TaskRepository;

@Service
public class TaskService {

	private List<Task> tasks = new ArrayList<>();
	
	@Autowired
	private TaskRepository repo;

	public TaskService() {
		Task task1 = new Task("Task 1");
		task1.setId(1L);

		Task task2 = new Task("Task 2");
		task2.setId(2L);

		tasks.add(task1);
		tasks.add(task2);
	}

	public Task CreateNewTask(String title) {
		return new Task(title);
	}

	public List<Task> GetAllTasks() {
		return tasks;
	}
	
	public boolean AddNewTask(String taskName){
		Task task = new Task(taskName);
		task.setId(100L);
		return this.tasks.add(task);
	}
	
	public Task GetTaskById(long id){
		for(Task t : this.tasks){
			if(t.getId() == id) return t;
		}
		
		return null;
//		this.tasks.stream().filter(t -> t.getId() == id)
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
}
