package com.example.userprofileservice.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.userprofileservice.dto.UserProfileDto;
import com.example.userprofileservice.entity.UserProfile;

public class UserProfileMapper {
	
	public static UserProfileDto toDto(UserProfile entity) {
		UserProfileDto dto = new UserProfileDto();
		
		dto.setId(entity.getId());
		dto.setUsername(entity.getUsername());
		dto.setRole(entity.getRole());
		dto.setPreferences(entity.getPreferences());
		dto.setCreatedAt(entity.getCreatedAt());
		
		return dto;
	}
	
	public static List<UserProfileDto> toDtoList(List<UserProfile> entityList){
		return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
}
