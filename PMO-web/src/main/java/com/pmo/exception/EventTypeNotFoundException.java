package com.pmo.exception;

public class EventTypeNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 7382992173926119165L;

	public EventTypeNotFoundException() {
		super();
	}
	
	public EventTypeNotFoundException(String message) {
		super(message);
	}
}
