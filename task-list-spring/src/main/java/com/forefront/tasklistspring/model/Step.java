package com.forefront.tasklistspring.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TaskSteps")
public class Step implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;
	
	private String content;
	
	@Enumerated(EnumType.STRING)
	@Column(name="Status")
	private ProgressStatus status;
	
	private LocalDateTime createdOn;
	private LocalDateTime completedOn;

	//DO NOT ADD THE FOREIGN KEY COLUMN TASKID AS A FIELD
	@ManyToOne
	@JoinColumn(name="taskId", nullable=false)
	private Task task;
	
	/* Properties */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}

	public void setContent(String name) {
		this.content = name;
	}

	@Enumerated(EnumType.STRING)
	public ProgressStatus getStatus() {
		return status;
	}

	public void setStatus(ProgressStatus status) {
		this.status = status;
	}

//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

//	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public LocalDateTime getCompletedOn() {
		return completedOn;
	}

	public void setCompletedOn(LocalDateTime completedOn) {
		this.completedOn = completedOn;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
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
	
	public Step(long id, String content) {
		this.status = ProgressStatus.NEW;
		this.createdOn = LocalDateTime.now();
		
		this.id = id;
		this.content = content;
	}

	/*Methods*/
	public void ToggleStatus(){
		if(this.status == ProgressStatus.NEW){
			this.CompleteStep();
		}
		else{
			this.UnCompleteStep();
		}
	}
	
	public void CompleteStep(){
		this.status = ProgressStatus.COMPLETE;
		this.completedOn = LocalDateTime.now();
	}
	
	public void UnCompleteStep(){
		this.status = ProgressStatus.NEW;
		this.completedOn = null;
	}


	
}
