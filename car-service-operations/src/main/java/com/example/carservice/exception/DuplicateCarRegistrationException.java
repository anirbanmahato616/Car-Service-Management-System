package com.example.carservice.exception;

public class DuplicateCarRegistrationException extends RuntimeException{
	
	public DuplicateCarRegistrationException(String message) {
		super(message);
	}
}
