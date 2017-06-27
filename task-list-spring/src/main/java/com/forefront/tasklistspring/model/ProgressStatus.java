package com.forefront.tasklistspring.model;

public enum ProgressStatus {
	NEW ("New"),
	COMPLETE ("Complete");

	private String displayValue;
	
	ProgressStatus(String displayValue) {
		this.displayValue = displayValue;
	}

	public String getDisplayValue() {
		return displayValue;
	}
	
}
