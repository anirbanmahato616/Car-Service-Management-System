package com.example.carservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.carservice.dto.CarServiceDto;
import com.example.carservice.service.CarServiceService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/carservice")
public class CarServiceController {
	
	@Autowired
	private CarServiceService carService;
	
	@GetMapping
	public ResponseEntity<List<CarServiceDto>> getAllCarService(){
		return ResponseEntity.ok(carService.getAllCarService());
	}
	
	@PostMapping("/save")
	public ResponseEntity<CarServiceDto> createCarService(@Valid @RequestBody CarServiceDto dto){
		return new ResponseEntity<>(carService.createCarService(dto), HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CarServiceDto> getCarServiceById(@PathVariable Long id){
		return ResponseEntity.ok(carService.getCarServiceById(id));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CarServiceDto> updateCarService(@PathVariable Long id, @RequestBody CarServiceDto dto){
		return new ResponseEntity<>(carService.updateCarService(id, dto), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCarService(@PathVariable Long id){
		return new ResponseEntity<>(carService.deleteCarService(id), HttpStatus.ACCEPTED);
	}
}
