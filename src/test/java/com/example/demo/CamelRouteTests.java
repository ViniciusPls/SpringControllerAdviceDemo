package com.example.demo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.demo.beans.ExampleBean;
import com.example.demo.service.CamelService;
import com.example.demo.service.impl.CamelServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CamelServiceImpl.class)
public class CamelRouteTests {

	@Autowired
	private CamelService service;
	
	@Test
	public void testExampleRoute() throws Exception {
		final ExampleBean in = new ExampleBean();
		in.setId(1);
		in.setName("My name is Bond, James Bond.");
		final ExampleBean out = service.testService(in);
		assertEquals("the out id bean needs be the same as in id", out.getId(), in.getId());
		assertEquals("the out name bean needs be the same as in name", out.getName(), in.getName());
	}
}
