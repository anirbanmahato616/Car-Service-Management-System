package com.example.carservice.service;

import java.util.List;

import com.example.carservice.dto.CarServiceDto;

public interface CarServiceService {
	
	List<CarServiceDto> getAllCarService();
	
	CarServiceDto createCarService(CarServiceDto dto);
	
	CarServiceDto getCarServiceById(Long id);
	
	CarServiceDto updateCarService(Long id, CarServiceDto dto);
	
	String deleteCarService(Long id);
}
