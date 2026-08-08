package com.example.carservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.carservice.dao.CarServiceRepository;
import com.example.carservice.dto.CarDetailsValidationDto;
import com.example.carservice.dto.CarServiceDto;
import com.example.carservice.entity.CarService;
import com.example.carservice.event.AuditEvent;
import com.example.carservice.exception.DuplicateCarRegistrationException;
import com.example.carservice.exception.ResourceNotFoundException;
import com.example.carservice.feign.CarValidationFeignClient;
import com.example.carservice.kafka.AuditProducer;
import com.example.carservice.security.SecurityUtil;
import com.example.carservice.utility.CarServiceMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CarServiceServiceImpl implements CarServiceService{
	
	@Autowired
	CarServiceRepository carServiceRepository;
	
	@Autowired
	private CarValidationFeignClient carValidationFeignClient;
	
	@Autowired
	private AuditProducer auditProducer;
	
	@Autowired
	private SecurityUtil securityUtil;
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public List<CarServiceDto> getAllCarService() {
		List<CarService> services = carServiceRepository.findAll();
		return CarServiceMapper.toDtoList(services);
	}

	@Override
	public CarServiceDto createCarService(CarServiceDto dto) {
		CarDetailsValidationDto validationResponse =
				carValidationFeignClient.validateCar(
						dto.getCarRegistrationNumber());
		if(!validationResponse.getIsValid()) {
			throw new ResourceNotFoundException(
					"Invalid Car Registration Number : "
					+ dto.getCarRegistrationNumber());
		}
		
		if(carServiceRepository.existsByCarRegistrationNumber(
				dto.getCarRegistrationNumber())) {
			throw new DuplicateCarRegistrationException(
					"Car Registration Number already exists");
		}
		
		CarService entity = CarServiceMapper.toEntity(dto);
		CarService savedEntity = 
				carServiceRepository.save(entity);
		String username = 
				securityUtil.getCurrentUsername();
		String role = securityUtil.getCurrentRole();
		
		AuditEvent event = new AuditEvent();
		
		event.setCarServiceId(savedEntity.getId());
		event.setAction("CREATE");
		event.setPerformedBy(username);
		event.setPerformedByRole(role);
		event.setTimestamp(java.time.LocalDateTime.now());
		event.setDetails(
				"Car Service Created for Registration Number "
				+ savedEntity.getCarRegistrationNumber());
		auditProducer.publishEvent(event);
		
		return CarServiceMapper.toDto(savedEntity);
	}

	@Override
	public CarServiceDto getCarServiceById(Long id) {
		CarService service = carServiceRepository.findById(id)
				.orElseThrow(() ->
						new ResourceNotFoundException(
								"Car Service not found with ID: " + id));
		
		return CarServiceMapper.toDto(service);
	}

	@Override
	public CarServiceDto updateCarService(Long id, CarServiceDto dto) {
		CarService existingService = carServiceRepository.findById(id)
				.orElseThrow(() ->
						new ResourceNotFoundException(
								"Car Service not found with ID: "+id));
		
		if(!existingService.getCarRegistrationNumber()
				.equals(dto.getCarRegistrationNumber())
				&& carServiceRepository.existsByCarRegistrationNumber(
						dto.getCarRegistrationNumber())) {
			
			throw new DuplicateCarRegistrationException(
					"Car Registration Number already exists");
		}
		
		if(dto.getCarRegistrationNumber() != null) {
			existingService.setCarRegistrationNumber(dto.getCarRegistrationNumber());
		}
		
		if(dto.getCustomerId() != null) {
			existingService.setCustomerId(dto.getCustomerId());
		}
		
		if(dto.getServiceType() != null) {
			existingService.setServiceType(dto.getServiceType());
		}
		
		if(dto.getServiceDate() != null) {
			existingService.setServiceDate(dto.getServiceDate());
		}
		
		if(dto.getServiceStatus() != null) {
			existingService.setServiceStatus(dto.getServiceStatus());
		}
		
		if(dto.getNotes() != null) {
			existingService.setNotes(dto.getNotes());
		}
		
		CarService updatedRecord = carServiceRepository.save(existingService);
		
		String username = 
				securityUtil.getCurrentUsername();
		String role = securityUtil.getCurrentRole();
		
		AuditEvent event = new AuditEvent();
		
		event.setCarServiceId(updatedRecord.getId());
		event.setAction("UPDATE");
		event.setPerformedBy(username);
		event.setPerformedByRole(role);
		event.setTimestamp(java.time.LocalDateTime.now());
		event.setDetails(
				"Car Service Updated for Registration Number "
				+ updatedRecord.getCarRegistrationNumber());
		auditProducer.publishEvent(event);
		
		return CarServiceMapper.toDto(updatedRecord);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public String deleteCarService(Long id) {
		CarService service = carServiceRepository.findById(id)
				.orElseThrow(() ->
						new ResourceNotFoundException(
								"Car Service not found with ID: "+id));
		
		carServiceRepository.delete(service);
		
		return "Deleted Successfully";
	}
}
