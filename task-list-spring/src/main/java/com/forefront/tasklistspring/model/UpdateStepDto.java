package com.forefront.tasklistspring.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class UpdateStepDto {

	@NotNull
	private long stepId;

	private String updatedContent;

	private ProgressStatus updatedStatus;

	public long getStepId() {
		return stepId;
	}

	public void setStepId(long stepId) {
		this.stepId = stepId;
	}

	public String getUpdatedContent() {
		return updatedContent;
	}

	public void setUpdatedContent(String updatedContent) {
		this.updatedContent = updatedContent;
	}

	public ProgressStatus getUpdatedStatus() {
		return updatedStatus;
	}

	public void setUpdatedStatus(ProgressStatus updatedStatus) {
		this.updatedStatus = updatedStatus;
	}

}
