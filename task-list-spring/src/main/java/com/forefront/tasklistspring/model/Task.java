package com.forefront.tasklistspring.model;

import java.util.ArrayList;
import java.util.List;

public class Task {

	private Long id;
	
	private String name;
	private List<Step> steps = new ArrayList<>();
	private ProgressStatus taskStatus = ProgressStatus.NEW;
	
	/* Properties */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProgressStatus getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(ProgressStatus taskStatus) {
		this.taskStatus = taskStatus;
	}
	
	/*
	 * Constructors and Methods  
	 */
	public Task(){
	}
	
	public Task(String title) {
		this.name = title;
	}

	public boolean AddStep(Step step){
		return this.steps.add(step);
	}
	
	public boolean RemoveStep(Step step){
		return this.steps.remove(step);
	}
	
	public void CompleteStep(Step step){
		this.steps.get(this.steps.indexOf(step)).CompleteStep();
	}

	
}
