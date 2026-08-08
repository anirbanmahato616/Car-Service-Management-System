package com.example.auth.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.entity.User;
import com.example.auth.repository.UserRepository;
import com.example.auth.security.CustomuserDetailsService;
import com.example.auth.security.JwtService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private CustomuserDetailsService customuserDetailsService;
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@Valid @RequestBody User user){
		if(userRepository.findByUsername(user.getUsername()).isPresent()) {
			return ResponseEntity.badRequest()
					.body("Username already exists");
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userRepository.save(user);
		
		return new ResponseEntity<>("User registered successfully!", HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest){
		String username = loginRequest.get("username");
		String password = loginRequest.get("password");
		
		authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password));
		
		UserDetails userDetails = customuserDetailsService.loadUserByUsername(username);
		String token = jwtService.generateToken(userDetails);
		return ResponseEntity.ok(Map.of("token", token));
	}
}
