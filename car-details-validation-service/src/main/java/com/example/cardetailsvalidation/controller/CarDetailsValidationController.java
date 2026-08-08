package com.example.cardetailsvalidation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cardetailsvalidation.dto.CarDetailsValidationDto;
import com.example.cardetailsvalidation.service.CarDetailsValidationService;

@RestController
@RequestMapping("/validation")
public class CarDetailsValidationController {
	
	@Autowired
	private CarDetailsValidationService carDetailsValidationService;
	
	@PostMapping("/{carRegistrationNumber}")
	public ResponseEntity<CarDetailsValidationDto> validateCar(@PathVariable String carRegistrationNumber){
		return new ResponseEntity<>(carDetailsValidationService.validateAndSave(carRegistrationNumber), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<CarDetailsValidationDto>> getAllData(){
		return new ResponseEntity<>(carDetailsValidationService.getAllData(), HttpStatus.OK);
	}
	
	@DeleteMapping("/id/{id}")
	public ResponseEntity<String> deleteData(@PathVariable Long id){
		return new ResponseEntity<>(carDetailsValidationService.deleteData(id), HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/registration/{carRegistrationNumber}")
	public ResponseEntity<String> deleteByCarRegistrationNumber(@PathVariable String carRegistrationNumber){
		return new ResponseEntity<>(carDetailsValidationService.deleteByCarRegistrationNumber(carRegistrationNumber), HttpStatus.ACCEPTED);
	}
}
