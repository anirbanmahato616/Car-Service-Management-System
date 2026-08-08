package com.example.cardetailsvalidation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.cardetailsvalidation.dto.CarDetailsValidationDto;
import com.example.cardetailsvalidation.entity.CarDetailsValidation;
import com.example.cardetailsvalidation.exception.ResourceNotFoundException;
import com.example.cardetailsvalidation.repository.CarDetailsValidationRepository;
import com.example.cardetailsvalidation.utility.CarDetailsValidationMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarDetailsValidationServiceImpl implements CarDetailsValidationService{
	@Autowired
	private CarDetailsValidationRepository carDetailsValidationRepo;

	@Override
	public CarDetailsValidationDto validateAndSave(String carRegistrationNumber) {
		boolean isValid = carRegistrationNumber.matches("^[A-Z]{2}[0-9]{2}[A-Z]{2}[0-9]{4}$");
		CarDetailsValidation validation = new CarDetailsValidation();
		validation.setIsValid(isValid);
		CarDetailsValidation saved = carDetailsValidationRepo.save(validation);
		return CarDetailsValidationMapper.toDto(saved);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public List<CarDetailsValidationDto> getAllData(){
		List<CarDetailsValidation> validations = carDetailsValidationRepo.findAll();
		return CarDetailsValidationMapper.toDtoList(validations);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public String deleteData(Long id) {
		CarDetailsValidation validation = carDetailsValidationRepo.findById(id)
											.orElseThrow(()->
													new ResourceNotFoundException("Validation record not found with id : "+ id));
		carDetailsValidationRepo.delete(validation);
		return "Validation record deleted successfully";
	}
	
	@Override
	public String deleteByCarRegistrationNumber(String carRegistrationNumber) {
		CarDetailsValidation validation = carDetailsValidationRepo.findByCarRegistrationNumber(carRegistrationNumber)
				.orElseThrow(()->
						new ResourceNotFoundException("Car registration number not found : "+carRegistrationNumber));
		carDetailsValidationRepo.delete(validation);
		return "Validation record deleted successfully";
	}
}
