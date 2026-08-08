package com.example.userprofileservice.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.userprofileservice.dto.UserProfileErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

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

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<UserProfileErrorResponse> handleResourceNotFoundException(
            ResourceNotFoundException ex) {

       UserProfileErrorResponse error = new UserProfileErrorResponse(
    		   "CAR-404",
    		   ex.getMessage(),
    		   LocalDateTime.now());
       return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserProfileErrorResponse> handleException(
            Exception ex) {
    	
    	UserProfileErrorResponse error = new UserProfileErrorResponse(
     		   "CAR-500",
     		   "Internal Server Error",
     		   LocalDateTime.now());
    	
        return new ResponseEntity<>(error,
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}