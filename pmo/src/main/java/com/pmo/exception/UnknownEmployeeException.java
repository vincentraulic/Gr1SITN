package com.pmo.exception;

import javax.management.openmbean.InvalidKeyException;

public class UnknownEmployeeException extends InvalidKeyException {

	private static final long serialVersionUID = -8321948979743021450L;

	public UnknownEmployeeException() {
		super();
	}
	
	public UnknownEmployeeException(String message) {
		super(message);
	}
}
