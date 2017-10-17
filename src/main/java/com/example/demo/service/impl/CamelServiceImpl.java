package com.example.demo.service.impl;

import org.apache.camel.CamelContext;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Service;

import com.example.demo.beans.ExampleBean;
import com.example.demo.service.CamelService;

@Service
public class CamelServiceImpl implements CamelService {
	
	@Produce(uri = "direct:testService")
	private ProducerTemplate testServiceProducer;

	@Override
	public ExampleBean testService(final ExampleBean in) {
		CamelContext context = new DefaultCamelContext();
		final ProducerTemplate t = context.createProducerTemplate();
		t.setDefaultEndpointUri("direct:testService");
		return (ExampleBean) t.requestBody(in);
	}

}
