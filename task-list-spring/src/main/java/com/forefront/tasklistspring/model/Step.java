package com.forefront.tasklistspring.model;

import java.time.*;

public class Step {
	private String name;
	private ProgressStatus status;
	private LocalDateTime createdOn;
	private LocalDateTime completedOn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProgressStatus getStatus() {
		return status;
	}

	public void setStatus(ProgressStatus status) {
		this.status = status;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalDateTime completedOn) {
		this.completedOn = completedOn;
	}

	public Step() {
		this.status = ProgressStatus.NEW;
		this.createdOn = LocalDateTime.now();
	}

	public void CompleteStep(){
		this.status = ProgressStatus.COMPLETE;
		this.completedOn = LocalDateTime.now();
	}
	
}
