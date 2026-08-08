package com.example.cardetailsvalidation.dto;

import java.time.LocalDateTime;

public class CarDetailsValidationErrorResponse {
	
	private String errorCode;
	private String message;
	private LocalDateTime timestamp;
	
	public CarDetailsValidationErrorResponse(String errorCode, String message, LocalDateTime timestamp) {
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
