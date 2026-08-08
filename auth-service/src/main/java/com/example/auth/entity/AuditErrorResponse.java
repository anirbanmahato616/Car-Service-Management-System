package com.example.auth.entity;

import java.time.LocalDateTime;

public class AuditErrorResponse {
	
	private String errorCode;
	private String message;
	private LocalDateTime timestamp;
	
	public AuditErrorResponse(String errorCode, String message, LocalDateTime timestamp) {
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
