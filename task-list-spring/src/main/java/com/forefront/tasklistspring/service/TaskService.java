package com.forefront.tasklistspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forefront.tasklistspring.model.Step;
import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.model.UpdateStepDto;
import com.forefront.tasklistspring.repository.StepRepository;
import com.forefront.tasklistspring.repository.TaskRepository;
import com.google.common.base.Strings;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepo;

	@Autowired
	private StepRepository stepRepo;
	
	public TaskService() {
	}

	/*
	 * Task
	 */
	public List<Task> GetAllTasks() {
		return this.taskRepo.findAll();
	}
	
	public Task AddNewTask(String taskName){
		Task task = new Task(taskName);
		return this.taskRepo.saveAndFlush(task);
	}
	
	public Task GetTaskById(long id){
		return this.taskRepo.findOne(id);
	}
	
	public Task UpdateTaskNameById(long id, String newName){
		Task existing = this.taskRepo.findOne(id);
//		BeanUtils.copyPropertieource, target);
		
		existing.setName(newName);
		return this.taskRepo.saveAndFlush(existing);
	}
	
	public boolean DeleteTask(long id){
		Task existing = this.taskRepo.findOne(id);
		this.taskRepo.delete(existing);
		return true;
//		Task task = GetTaskById(id);
//		return tasks.remove(task);
	}
	
	/*
	 * Step
	 */
	public Task AddNewStep(long taskId, String stepContent){
		Task task = GetTaskById(taskId);
		Step step = new Step(stepContent);
		step.setTask(task);
		
		this.stepRepo.saveAndFlush(step);
		
		return this.taskRepo.findOne(taskId);
	}
	
	public Step UpdateStep(UpdateStepDto updatedStep){
//		Task task = GetTaskById(taskId);
//		if(task == null) return null;
		
//		Step step = task.GetStepById(updatedStep.getStepId());
		Step step = this.stepRepo.findOne(updatedStep.getStepId());
		if(step == null) return null;
		
		if(!Strings.isNullOrEmpty(updatedStep.getUpdatedContent())){
			step.setContent(updatedStep.getUpdatedContent());
		}
		
		if(updatedStep.isToggleStatus()){
			step.ToggleStatus();
		}
		
		return this.stepRepo.saveAndFlush(step);
	}
	
	public boolean DeleteStep(long stepId){
		Step existing = this.stepRepo.findOne(stepId);
		this.stepRepo.delete(existing);
		return true;
	}
	
	
}
