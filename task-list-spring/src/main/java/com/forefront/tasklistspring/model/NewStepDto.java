package com.forefront.tasklistspring.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class NewStepDto {

	@NotNull
	private long taskId;
	
	@NotEmpty
	private String stepContent;
	
	public String getStepContent() {
		return stepContent;
	}

	public void setStepContent(String stepContent) {
		this.stepContent = stepContent;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}
	
}
