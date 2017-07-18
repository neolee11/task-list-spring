package com.forefront.tasklistspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.forefront.tasklistspring.model.Step;

@Repository
public interface StepRepository extends JpaRepository<Step, Long> {
	
	
}
