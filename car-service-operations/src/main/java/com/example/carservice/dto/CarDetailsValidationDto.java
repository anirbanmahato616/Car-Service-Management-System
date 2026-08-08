package com.example.carservice.dto;

import java.time.LocalDateTime;

public class CarDetailsValidationDto {
	
	private Long id;
	private String carRegistrationNumber;
	private boolean isValid;
	private LocalDateTime validationTimestamp;
	
	public CarDetailsValidationDto() {
		
	}
	
	public CarDetailsValidationDto(String carRegistrationNumber) {
		this.carRegistrationNumber = carRegistrationNumber;
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
	public boolean getIsValid() {
		return isValid;
	}
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}
	public LocalDateTime getValidationTimestamp() {
		return validationTimestamp;
	}
	public void setValidationTimestamp(LocalDateTime validationTimestamp) {
		this.validationTimestamp = validationTimestamp;
	}
	
	
}
