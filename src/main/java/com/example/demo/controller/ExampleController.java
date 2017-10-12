package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.CustomException;
import com.example.demo.exception.ExampleCustomNPE;

/**
 * An example of a mvc controller
 * 
 * @author Carlos Pancioni
 *
 */
@RestController
public class ExampleController {

	/**
	 * Redirects the root url to the main page of the project
	 * 
	 * @return the main page
	 */
	@GetMapping(value = "/")
	public String main() {
		System.out.println("A controller being called");
		return "main";
	}

	/**
	 * Returns an null pointer exception
	 *
	 * @return an exception
	 * @throws Exception
	 */
	@GetMapping(value = "/nullExceptionHandler/")
	public String nullTest() throws Exception {
		System.out.println("Unexpected situation!");
		String s = null;
		System.out.println(s.length());
		return "nullTest";
	}

	/**
	 * Returns an example of a custom exception being called when something goes
	 * wrong
	 * 
	 * @param string
	 *            for this example this parameter will be always <b>null</b> to
	 *            broke in line 42.
	 * @return an custom exception
	 * @throws CustomException
	 */
	@GetMapping(value = "/customExceptionHandler/{id}")
	public ResponseEntity<Integer> exceptionTest(@PathVariable final Integer id) throws CustomException {
		if (id.equals(1)) {
			throw new ExampleCustomNPE("UNIQUE_CODE_FOR_THE_EXCEPTION",
					"This is a example of a custom exception!! please, DO NOT enter in contact with the system administrador.");
		}
		return ResponseEntity.status(HttpStatus.OK).body(id);
	}
}
