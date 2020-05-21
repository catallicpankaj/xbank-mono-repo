package com.ms1.ms1Assignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<String> handleException(Throwable e) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server ran into issue. Try again!!!");
	}
}
