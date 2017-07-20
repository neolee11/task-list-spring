package com.forefront.tasklistspring;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.forefront.tasklistspring.controller.HomeController;

import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;


public class HomeControllerTests {

	@Test
	public void sayHelloTest() {
		HomeController homeController = new HomeController();
		Model model = new ExtendedModelMap();
		String result = homeController.sayHello(model);
		assertEquals(result, "greeting");
	}

}
