package com.pmo.exception;

public class ProjectNotFoundException extends IllegalArgumentException {
	
	private static final long serialVersionUID = -4677970104267756319L;

	public ProjectNotFoundException() {
		super();
	}
	
	public ProjectNotFoundException(String message) {
		super(message);
	}
	
}
