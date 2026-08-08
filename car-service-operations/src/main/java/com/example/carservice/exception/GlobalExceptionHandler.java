package com.example.carservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.carservice.dto.CarServiceErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex){
		Map<String, String> errors = new HashMap<>();
		
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(DuplicateCarRegistrationException.class)
    public ResponseEntity<CarServiceErrorResponse> handleResourceNotFoundException(
    		DuplicateCarRegistrationException ex) {

		CarServiceErrorResponse error = new CarServiceErrorResponse(
    		   "CAR-404",
    		   ex.getMessage(),
    		   LocalDateTime.now());
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
	
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CarServiceErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex) {

    	CarServiceErrorResponse error = new CarServiceErrorResponse(
    		   "CAR-404",
    		   ex.getMessage(),
    		   LocalDateTime.now());
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CarServiceErrorResponse> handleException(
            Exception ex) {
    	
    	CarServiceErrorResponse error = new CarServiceErrorResponse(
     		   "CAR-500",
     		   "Internal Server Error",
     		   LocalDateTime.now());
    	
        return new ResponseEntity<>(error,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}