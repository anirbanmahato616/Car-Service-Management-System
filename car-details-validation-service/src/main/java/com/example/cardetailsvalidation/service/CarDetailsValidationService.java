package com.example.cardetailsvalidation.service;

import java.util.List;

import com.example.cardetailsvalidation.dto.CarDetailsValidationDto;

public interface CarDetailsValidationService {
	public List<CarDetailsValidationDto> getAllData();
	public String deleteData(Long id);
	public String deleteByCarRegistrationNumber(String carRegistrationNumber);
	public CarDetailsValidationDto validateAndSave(String carRegistrationNumber);
}
