package com.example.demo.routes;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.stereotype.Component;

import com.example.demo.beans.ExampleBeanRoute;

@Component
public class ExampleCamelTransformationRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		CamelContext context = new DefaultCamelContext();

		// @formatter:off
 
		from("direct:serviceTest")
			.setHeader("InitialValue", constant("body"))        // save the first one in a header
			.bean(ExampleBeanRoute.class, "firstMethodEntry")   // will manipulate the body
			.bean(ExampleBeanRoute.class, "secondMethodEntry")  // will manipulate the body again, ignoring the header
			.bean(ExampleBeanRoute.class, "thirdMethodEntry");	// will ignore the body, manipulating and sending the header as body response
		
		// @formatter:on

//		context.start();
		Thread.sleep(10000);
//		context.stop();
	}
}