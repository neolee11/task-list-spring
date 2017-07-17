package com.forefront.tasklistspring.model;

import java.util.ArrayList;
import java.util.List;

public class Task {

	private Long id;
	
	private String name;
	private List<Step> steps = new ArrayList<>();
	
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
	
	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}
	
	/*
	 * Constructors   
	 */
	public Task(){
	}
	
	public Task(String title) {
		this.name = title;
	}

	/*
	 * Methods
	 */
	public boolean AddStep(Step step){
		return this.steps.add(step);
	}
	
	public boolean RemoveStep(Step step){
		return this.steps.remove(step);
	}
	
	public boolean RemoveStepById(long stepId){
		Step step = GetStepById(stepId);
		if(step == null) return false;
		
		return RemoveStep(step);
	}
	
	public Step GetStepById(long stepId){
		for(Step step : this.steps){
			if(step.getId() == stepId){
				return step;
			}
		}
		return null;
	}
	
	public ProgressStatus TaskStatus() {
		
		for(Step step: steps){
			if(step.getStatus() == ProgressStatus.NEW){
				return ProgressStatus.NEW;
			}
		}
		
		return ProgressStatus.COMPLETE;
	}
	
	/*public void CompleteStep(Step step){
		this.steps.get(this.getSteps().indexOf(step)).CompleteStep();
	}*/



	
}
