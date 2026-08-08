package com.example.cardetailsvalidation.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.cardetailsvalidation.dto.CarDetailsValidationDto;
import com.example.cardetailsvalidation.entity.CarDetailsValidation;


public class CarDetailsValidationMapper {
	public static CarDetailsValidation toEntity(CarDetailsValidationDto dto) {
		return new CarDetailsValidation(dto.getCarRegistrationNumber());
	}
	
	public static CarDetailsValidationDto toDto(CarDetailsValidation entity) {
		CarDetailsValidationDto dto = new CarDetailsValidationDto();
		
		dto.setId(entity.getId());
		dto.setCarRegistrationNumber(entity.getCarRegistrationNumber());
		dto.setIsValid(entity.getIsValid());
		dto.setValidationTimestamp(entity.getValidationTimestamp());
		
		return dto;
	}
	
	public static List<CarDetailsValidationDto> toDtoList(List<CarDetailsValidation> entityList){
		return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
	
	public static List<CarDetailsValidation> toEntityList(List<CarDetailsValidationDto> dtoList){
		return dtoList.stream().map(dto -> toEntity(dto)).collect(Collectors.toList());
	}
}
