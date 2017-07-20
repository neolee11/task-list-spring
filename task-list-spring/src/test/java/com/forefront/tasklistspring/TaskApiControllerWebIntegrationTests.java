package com.forefront.tasklistspring;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.forefront.tasklistspring.model.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class TaskApiControllerWebIntegrationTests {
	
	@Autowired
	private Environment env;
	
	@Test
	public void testGetAllTasks() throws Exception {
		String port = env.getProperty("server.port");
		
		TestRestTemplate restTemplate = new TestRestTemplate();
		
		String url = "http://localhost:" + port + "/api/tasks";
		
		 ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		 
		 assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
		 
		 ObjectMapper objectMapper = new ObjectMapper();
		 JsonNode responseJson = objectMapper.readTree(response.getBody());
		 
		 //Try to convert json to POJO, not working here
		/* ObjectReader reader = objectMapper.readerFor(new TypeReference<List<Task>>() {});
		 List<Task> tasks = reader.readValue(responseJson);*/
		 
		 
		 assertThat(responseJson.isMissingNode(), is(false));
		 System.out.println(responseJson.toString());
	}

}
