package com.pratian.springbootdemo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DemoGlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<String> studentNotFoundHandler(Throwable throwable){
		return new ResponseEntity<String>(throwable.getMessage(), HttpStatus.NOT_FOUND);
	}

}
