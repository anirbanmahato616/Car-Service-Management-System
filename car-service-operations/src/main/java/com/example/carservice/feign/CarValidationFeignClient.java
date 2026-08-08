package com.example.carservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.carservice.dto.CarDetailsValidationDto;
import com.example.carservice.feigninterceptor.FeignInterceptorConfig;

@FeignClient(name="CAR-DETAILS-VALIDATION-SERVICE", configuration=FeignInterceptorConfig.class)
public interface CarValidationFeignClient {
	@PostMapping("/validation/{carRegistrationNumber}")
	CarDetailsValidationDto validateCar(@PathVariable("carRegistrationNumber") String carRegistrationNumber);
}
