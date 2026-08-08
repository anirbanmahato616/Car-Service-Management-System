package com.example.auditservice.event;

import java.time.LocalDateTime;

public class AuditEvent {
	
	private Long carServiceId;
	private String action;
	private LocalDateTime timestamp;
	private String performedBy;
	private String performedByRole;
	private String details;
	
	public AuditEvent() {
		
	}

	public Long getCarServiceId() {
		return carServiceId;
	}

	public void setCarServiceId(Long carServiceId) {
		this.carServiceId = carServiceId;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getPerformedBy() {
		return performedBy;
	}

	public void setPerformedBy(String performedBy) {
		this.performedBy = performedBy;
	}

	public String getPerformedByRole() {
		return performedByRole;
	}

	public void setPerformedByRole(String performedByRole) {
		this.performedByRole = performedByRole;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
