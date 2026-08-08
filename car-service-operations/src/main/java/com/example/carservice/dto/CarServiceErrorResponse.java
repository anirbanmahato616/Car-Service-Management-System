package com.example.carservice.dto;

import java.time.LocalDateTime;

public class CarServiceErrorResponse {
	
	private String errorCode;
	private String message;
	private LocalDateTime timestamp;
	
	public CarServiceErrorResponse(String errorCode, String message, LocalDateTime timestamp) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}
