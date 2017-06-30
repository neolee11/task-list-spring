package com.forefront.tasklistspring.model;

import org.hibernate.validator.constraints.NotEmpty;

public class NewTaskDto {

	@NotEmpty
	private String taskName;

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
}
