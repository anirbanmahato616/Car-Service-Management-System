package com.example.carservice.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;

public class CarServiceDto {
	
	private Long id;
	
	@NotBlank(message = "Car Registration Number is required")
	@Size(max=20,message="Car Registration Number cannot exceed 20 characters")
	private String carRegistrationNumber;
	
	@NotNull(message = "Customer ID is required")
	private Long customerId;
	
	@NotBlank(message = "Service Type is required")
	@Size(max=50, message="Service Type cannot exceed 50 characters")
	private String serviceType;
	
	@NotNull(message = "Service Date is required")
	@PastOrPresent(message="Service Date cannot be in the future")
	private LocalDate serviceDate;
	
	@NotBlank(message = "Service Status is required")
	@Size(max=50, message="Service Status cannot exceed 50 characters")
	private String serviceStatus;
	
	@Size(max=250, message="Notes cannot exceed 250 characters")
	private String notes;
	
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	
	public CarServiceDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarServiceDto(
			 String carRegistrationNumber,
			Long customerId,
			 String serviceType,
			LocalDate serviceDate,
			 String serviceStatus,
			 String notes) {
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
