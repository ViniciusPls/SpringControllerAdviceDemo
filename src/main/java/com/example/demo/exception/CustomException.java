package com.example.demo.exception;

public class CustomException extends Exception {

	private static final long serialVersionUID = -1512629506795331698L;
	
	protected String code;
	protected String message;
	
	public CustomException(final String code, final String message) {
		super(message);
	}

	public CustomException(final String code, final String message, final Throwable cause) {
		super(message);
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
