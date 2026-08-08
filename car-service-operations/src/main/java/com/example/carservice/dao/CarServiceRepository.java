package com.example.carservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.carservice.entity.CarService;

public interface CarServiceRepository extends JpaRepository<CarService,Long>{
	boolean existsByCarRegistrationNumber(String carRegistrationNumber);
}
