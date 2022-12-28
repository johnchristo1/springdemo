package com.pratian.springbootdemo.exceptions;

public class StudentNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8892879680597331068L;

	public StudentNotFoundException() {
		super();
		
	}

	public StudentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	public StudentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public StudentNotFoundException(String message) {
		super(message);
		
	}

	public StudentNotFoundException(Throwable cause) {
		super(cause);
		
	}

}
