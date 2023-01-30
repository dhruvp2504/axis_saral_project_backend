package com.axis.saral.service.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -150L;

	public EmployeeNotFoundException() {

	}

	public EmployeeNotFoundException(String message) {
		super(message);
	}

}
