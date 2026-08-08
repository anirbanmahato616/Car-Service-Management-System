package com.example.cardetailsvalidation.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="car_validation_logs")
public class CarDetailsValidation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String carRegistrationNumber;
	
	@Column(nullable=false)
	private boolean isValid;
	
	@CreationTimestamp
	private LocalDateTime validationTimestamp;
	
	public CarDetailsValidation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarDetailsValidation(String carRegistrationNumber) {
		super();
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
