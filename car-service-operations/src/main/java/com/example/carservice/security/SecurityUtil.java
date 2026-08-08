package com.example.carservice.security;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityUtil {
	public String getCurrentUsername() {
		return SecurityContextHolder.getContext()
				.getAuthentication()
				.getName();
	}
	
	public String getCurrentRole() {
		return SecurityContextHolder.getContext()
				.getAuthentication()
				.getAuthorities()
				.stream()
				.map(authority -> authority.getAuthority())
				.findFirst()
				.orElse(null);
	}
}
