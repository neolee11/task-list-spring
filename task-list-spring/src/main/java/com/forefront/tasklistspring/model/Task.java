package com.forefront.tasklistspring.model;

import java.util.ArrayList;
import java.util.List;

public class Task {

	private String title;
	private List<Step> steps = new ArrayList<>();
	private ProgressStatus taskStatus = ProgressStatus.NEW;
	
	/* Properties */
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
		this.title = title;
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
