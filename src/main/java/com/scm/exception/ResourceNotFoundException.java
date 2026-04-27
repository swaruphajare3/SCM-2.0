package com.scm.exception;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException() {
		super("Resources not found");
	}

}
