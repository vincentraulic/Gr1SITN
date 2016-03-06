package com.pmo.exception;

public class RoleNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = -8321948979743021450L;

	public RoleNotFoundException() {
		super();
	}
	
	public RoleNotFoundException(String message) {
		super(message);
	}
}
