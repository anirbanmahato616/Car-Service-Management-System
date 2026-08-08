package com.example.cardetailsvalidation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cardetailsvalidation.entity.CarDetailsValidation;

public interface CarDetailsValidationRepository extends JpaRepository<CarDetailsValidation, Long>{
	Optional<CarDetailsValidation> findByCarRegistrationNumber(String carRegistrationNumber);
}
