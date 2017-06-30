package com.forefront.tasklistspring.model;

import java.time.*;

public class Step {
	
	private Long id = 5L;
	
	private String content;
	private ProgressStatus status;
	private LocalDateTime createdOn;
	private LocalDateTime completedOn;

	/* Properties */
	public String getContent() {
		return content;
	}

	public void setContent(String name) {
		this.content = name;
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

	/*Constructors*/
	public Step() {
		this.status = ProgressStatus.NEW;
		this.createdOn = LocalDateTime.now();
	}
	
	public Step(String content) {
		this.status = ProgressStatus.NEW;
		this.createdOn = LocalDateTime.now();
		this.content = content;
	}

	/*Methods*/
	public void CompleteStep(){
		this.status = ProgressStatus.COMPLETE;
		this.completedOn = LocalDateTime.now();
	}
	
	public void UnCompleteStep(){
		this.status = ProgressStatus.NEW;
		this.completedOn = null;
	}
}
