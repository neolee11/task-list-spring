package com.forefront.tasklistspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forefront.tasklistspring.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	
}
