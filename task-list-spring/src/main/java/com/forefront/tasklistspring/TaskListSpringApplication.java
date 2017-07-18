package com.forefront.tasklistspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

@EntityScan(
        basePackageClasses = {TaskListSpringApplication.class, Jsr310JpaConverters.class}
)
@SpringBootApplication
public class TaskListSpringApplication {

	public static void main(String[] args) {
		
//		Sprint Common Application Properties
//		https://docs.spring.io/spring-boot/docs/current/reference/html/common-application-properties.html
			
		SpringApplication.run(TaskListSpringApplication.class, args);
	}
}
