package com.example.carservice.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car_services")
public class CarService {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique=true)
	private String carRegistrationNumber;
	
	private Long customerId;
	
	private String serviceType;
	
	private LocalDate serviceDate;
	
	private String serviceStatus;
	
	private String notes;
	
	@CreationTimestamp
	@Column(name="created_at", nullable=false)
	private LocalDateTime createdAt;
	
	@UpdateTimestamp
	@Column(name="updated_at", nullable=false)
	private LocalDateTime updatedAt;
	
	public CarService() {
		
	}

	public CarService(String carRegistrationNumber, Long customerId, String serviceType, LocalDate serviceDate,
			String serviceStatus, String notes) {
		super();
		this.carRegistrationNumber = carRegistrationNumber;
		this.customerId = customerId;
		this.serviceType = serviceType;
		this.serviceDate = serviceDate;
		this.serviceStatus = serviceStatus;
		this.notes = notes;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCarRegistrationNumber() {
		return carRegistrationNumber;
	}

	public void setCarRegistrationNumber(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public LocalDate getServiceDate() {
		return serviceDate;
	}

	public void setServiceDate(LocalDate serviceDate) {
		this.serviceDate = serviceDate;
	}

	public String getServiceStatus() {
		return serviceStatus;
	}

	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	
}
