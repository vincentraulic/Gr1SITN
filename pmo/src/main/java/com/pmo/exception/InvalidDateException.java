package com.pmo.exception;

public class InvalidDateException extends IllegalArgumentException {

	private static final long serialVersionUID = -8321948979743021450L;

	public InvalidDateException() {
		super();
	}
	
	public InvalidDateException(String message) {
		super(message);
	}
}
