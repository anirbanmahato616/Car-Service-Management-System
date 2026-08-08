package com.example.auditservice.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car_service_audit_logs")
public class AuditLog {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private Long carServiceId;
	
	private String action;
	
	@CreationTimestamp
	private LocalDateTime timestamp;
	
	private String performedBy;
	
	private String performedByRole;
	
	@Column(columnDefinition = "TEXT")
	private String details;
	
	public AuditLog() {
		
	}

	public AuditLog(Long carServiceId, String action, String performedBy, String performedByRole, String details) {
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
