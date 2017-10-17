package com.example.demo.beans;

import com.example.demo.routes.ExampleCamelTransformationRoute;

/**
 * 
 * @author Carlos Pancioni
 *
 */
public class ExampleBeanRoute {

	/**
	 * In this first example method, we will manipulate the incoming value, called
	 * body and save the original one in a header option (it can be saw in camel
	 * route builder {@link ExampleCamelTransformationRoute}
	 * 
	 * @param body
	 *            the entrance parameter of the route
	 * @return
	 */
	public ExampleBean firstMethodEntry(final ExampleBean body) {
		body.setId(100);
		body.setName("James Bond is dead, now he's a constant inside the route.");

		return body;
	}

	/**
	 * Manipulates the body object just if the first method was called, sending a
	 * new body to the next method.
	 * 
	 * @param body
	 *            the parameter sent by the first method
	 * @return
	 */
	public ExampleBean secondMethodEntry(final ExampleBean body) {
		if (body.getId().equals(100)) {
			body.setId(200);
			body.setName("Is he really dead ?");
		}
		return body;
	}

	/**
	 * Will ignore the new incoming body and return the original value that we saved
	 * in a header constant
	 * 
	 * @param body
	 *            the new incoming body from second method.
	 * @param header
	 *            the initial value object before the first manipulation
	 * @return the original values
	 */
	public ExampleBean thirdMethodEntry(final ExampleBean body, final ExampleBean header) {
		System.out.println("------------------ BODY ------------------");
		System.out.println(body.getName());
		System.out.println("------------------ HEADER ------------------");
		System.out.println("Someone is comming, who is this guy ? DDDD:");
		System.out.println(header.getName());
		return header;
	}
}
