package com.example.demo.exception;

public class CustomNullPointerException extends CustomException {

	private static final long serialVersionUID = -2738606341657555167L;

	public CustomNullPointerException(final String code, final String message) {
		super(code, message);
	}

	public CustomNullPointerException(final String code, final String message, final Throwable cause) {
		super(code, message, cause);
	}
}
