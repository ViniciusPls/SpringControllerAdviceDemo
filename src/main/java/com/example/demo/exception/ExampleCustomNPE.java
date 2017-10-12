package com.example.demo.exception;

/**
 * An example of a custom exception class
 * 
 * @author Carlos Pancioni
 *
 */
public class ExampleCustomNPE extends CustomException {

	private static final long serialVersionUID = -6328764910118256665L;

	public ExampleCustomNPE(final String code, final String message) {
		super(code, message);
		
		this.code = code;
		this.message = message;
	}

	public ExampleCustomNPE(final String code, final String message, final Throwable cause) {
		super(code, message, cause);
		
		this.code = code;
		this.message = message;
	}
}
