package com.forefront.tasklistspring;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.forefront.tasklistspring.model.Task;
import com.forefront.tasklistspring.repository.TaskRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@RunWith(SpringJUnit4ClassRunner.class) //mark as an integration test
@SpringBootTest(classes = TaskListSpringApplication.class)
public class TaskRepositoryIntegrationTests {
	
	@Autowired
	private TaskRepository repo;
	
	@Test
	public void testFindAll(){
		List<Task> result = repo.findAll();
		assertThat(result.size(), is(greaterThanOrEqualTo(1)));
	}
	
}
