package com.example.demo.builder;

import org.springframework.http.HttpStatus;

import com.example.demo.dto.ErrorResponse;
import com.example.demo.dto.SuccessResponse;
import com.example.demo.exception.CustomException;

public class ResponseBuilder {

	public static SuccessResponse successResponse() {
		// TODO: SEE THE VIABILITY WITH THE TEAM
		return null;
	}

	public static ErrorResponse errorResponse(final CustomException e, final HttpStatus status) {
		return new ErrorResponse(status, e.getCode(), e.getMessage(), e.getStackTrace().toString());
	}

	public static ErrorResponse errorResponse(final Exception e, final HttpStatus status) {
		return new ErrorResponse(status, "", "Unexpected error condition!", e.getStackTrace().toString());
	}

}
