package com.example.userprofileservice.dto;

import java.time.LocalDateTime;

public class UserProfileDto {
	private Long id;
	private String username;
	private String role;
	private String preferences;
	private LocalDateTime createdAt;
	
	public UserProfileDto() {

	}

	public UserProfileDto(String preferences) {
		super();
		this.preferences = preferences;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getPreferences() {
		return preferences;
	}

	public void setPreferences(String preferences) {
		this.preferences = preferences;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	
}