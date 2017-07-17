package com.forefront.tasklistspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forefront.tasklistspring.model.ProgressStatus;
import com.forefront.tasklistspring.model.Step;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.model.UpdateStepDto;
import com.forefront.tasklistspring.repository.TaskRepository;
import com.google.common.base.Strings;

@Service
public class TaskService {

//	private List<Task> tasks = new ArrayList<>();
	
	@Autowired
	private TaskRepository repo;

	public TaskService() {
		
//		Task task1 = new Task("Task 1");
//		task1.setId(1L);
//		task1.AddStep(new Step(1L, "step 1"));
//		task1.AddStep(new Step(2L, "step 2"));
//
//		Task task2 = new Task("Task 2");
//		task2.setId(2L);
//		task2.AddStep(new Step(1L, "do this"));
//		task2.AddStep(new Step(2L, "do that"));
//		
//		tasks.add(task1);
//		tasks.add(task2);
	}

	/*
	 * Task
	 */
	public List<Task> GetAllTasks() {
		return this.repo.findAll();
	}
	
	public Task AddNewTask(String taskName){
		Task task = new Task(taskName);
//		task.setId(100L);
		return this.repo.saveAndFlush(task);
//		return this.tasks.add(task) ? task : null;
	}
	
	public Task GetTaskById(long id){
		return this.repo.findOne(id);
		
//		for(Task t : this.tasks){
//			if(t.getId() == id) return t;
//		}
//		return null;
	}
	
	public Task UpdateTaskNameById(long id, String newName){
		Task existing = this.repo.findOne(id);
//		BeanUtils.copyProperties(source, target);
		
		existing.setName(newName);
		return this.repo.saveAndFlush(existing);
		
//		for(Task t : this.tasks){
//			if(t.getId() == id){
//				t.setName(newName);
//				return t;
//			}
//		}
//		return null;
	}
	
	public boolean DeleteTask(long id){
		Task existing = this.repo.findOne(id);
		this.repo.delete(existing);
		
		return true;
//		Task task = GetTaskById(id);
//		return tasks.remove(task);
	}
	
	/*
	 * Step
	 */
	public Task AddNewStep(long taskId, String stepContent){
		Task task = GetTaskById(taskId);
		if(task == null) return null;
		
		task.AddStep(new Step(stepContent));
		return this.repo.saveAndFlush(task);
	}
	
	public Step UpdateStep(long taskId, UpdateStepDto updatedStep){
		Task task = GetTaskById(taskId);
		if(task == null) return null;
		
		Step step = task.GetStepById(updatedStep.getStepId());
		if(step == null) return null;
		
		if(!Strings.isNullOrEmpty(updatedStep.getUpdatedContent())){
			step.setContent(updatedStep.getUpdatedContent());
		}
		
		if(updatedStep.isToggleStatus()){
			step.ToggleStatus();
		}
		
		this.repo.saveAndFlush(task);
		
		return step;
	}
	
	public boolean DeleteStep(long taskId, long stepId){
		
		Task task = GetTaskById(taskId);
		task.RemoveStepById(stepId);
		
		this.repo.saveAndFlush(task);
		return true;
	}
	
	
}
