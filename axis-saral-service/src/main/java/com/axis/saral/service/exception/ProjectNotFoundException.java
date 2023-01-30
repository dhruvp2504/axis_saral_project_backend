package com.axis.saral.service.exception;

public class ProjectNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -160L;

	public ProjectNotFoundException() {
		
	}

	public ProjectNotFoundException(String message) {
		super(message);
	}
	
	
}
