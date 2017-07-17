CREATE TABLE Tasks(
	TaskID INT AUTO_INCREMENT NOT NULL,	
	Name VARCHAR(255) NOT NULL,
	PRIMARY Key (TaskID)
);

CREATE TABLE TaskSteps(
	ID INT AUTO_INCREMENT NOT NULL,
	TaskID INT NOT NULL,	
	Content VARCHAR(255) NOT NULL,
	Status VARCHAR(255),
	CreatedOn TIMESTAMP,
	CompletedOn TIMESTAMP,
	PRIMARY Key (ID),
	FOREIGN KEY (TaskID) REFERENCES Tasks(TaskID)
);