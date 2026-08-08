package com.example.carservice.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.carservice.dto.CarServiceDto;
import com.example.carservice.entity.CarService;

public class CarServiceMapper {
	public static CarService toEntity(CarServiceDto dto) {
		return new CarService(dto.getCarRegistrationNumber(),
								dto.getCustomerId(),
								dto.getServiceType(),
								dto.getServiceDate(),
								dto.getServiceStatus(),
								dto.getNotes());
	}
	
	public static CarServiceDto toDto(CarService entity) {
		CarServiceDto dto = new CarServiceDto();
		
		dto.setId(entity.getId());
		dto.setCarRegistrationNumber(entity.getCarRegistrationNumber());
		dto.setCustomerId(entity.getCustomerId());
		dto.setServiceType(entity.getServiceType());
		dto.setServiceDate(entity.getServiceDate());
		dto.setServiceStatus(entity.getServiceStatus());
		dto.setNotes(entity.getNotes());
		dto.setCreatedAt(entity.getCreatedAt());
		dto.setUpdatedAt(entity.getUpdatedAt());
		
		return dto;
	}
	
	public static List<CarServiceDto> toDtoList(List<CarService> entityList){
		return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
	
	public static List<CarService> toEntityList(List<CarServiceDto> dtoList){
		return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
}
