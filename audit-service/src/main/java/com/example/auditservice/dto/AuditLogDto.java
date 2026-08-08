package com.example.auditservice.dto;

import java.time.LocalDateTime;

public class AuditLogDto {
	
	private Long id;
	private Long carServiceId;
	private String action;
	private LocalDateTime timestamp;
	private String performedBy;
	private String performedByRole;
	private String details;
	
	public AuditLogDto() {
		
	}

	public AuditLogDto(Long carServiceId, String action, String performedBy, String performedByRole, String details) {
		super();
		this.carServiceId = carServiceId;
		this.action = action;
		this.performedBy = performedBy;
		this.performedByRole = performedByRole;
		this.details = details;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
