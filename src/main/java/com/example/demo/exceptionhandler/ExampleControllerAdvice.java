package com.example.demo.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.builder.ResponseBuilder;
import com.example.demo.dto.ErrorResponse;
import com.example.demo.exception.ExampleCustomNPE;

@ControllerAdvice(annotations = {RestController.class, Controller.class})
public class ExampleControllerAdvice {

	@ExceptionHandler(value = ExampleCustomNPE.class)
	public ResponseEntity<ErrorResponse> customException(final ExampleCustomNPE e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBuilder.errorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR));
	}

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ErrorResponse> customException(final Exception e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ResponseBuilder.errorResponse(e, HttpStatus.INTERNAL_SERVER_ERROR));
	}

}