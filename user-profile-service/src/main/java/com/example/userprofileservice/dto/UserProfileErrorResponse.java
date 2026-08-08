package com.example.userprofileservice.dto;

import java.time.LocalDateTime;

public class UserProfileErrorResponse {
	private String errorCode;
	private String message;
	private LocalDateTime timestamp;
	
	public UserProfileErrorResponse(String errorCode, String message, LocalDateTime timestamp) {
		super();
		this.errorCode = errorCode;
		this.message = message;
		this.timestamp = timestamp;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
