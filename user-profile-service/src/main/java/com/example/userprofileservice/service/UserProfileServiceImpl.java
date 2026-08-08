package com.example.userprofileservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.userprofileservice.dto.UserProfileDto;
import com.example.userprofileservice.entity.UserProfile;
import com.example.userprofileservice.exception.ResourceNotFoundException;
import com.example.userprofileservice.repository.UserProfileRepository;
import com.example.userprofileservice.service.UserProfileService;
import com.example.userprofileservice.utility.UserProfileMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserProfileServiceImpl implements UserProfileService {
	
	@Autowired
	UserProfileRepository userProfileRepository;
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public List<UserProfileDto> getAllUserProfile() {
		List<UserProfile> entityList = userProfileRepository.findAll();
		return UserProfileMapper.toDtoList(entityList);
	}

	@Override
	public UserProfileDto createUserProfile(UserProfileDto dto) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		String role = authentication.getAuthorities()
				.iterator()
				.next()
				.getAuthority();
		UserProfile entity = new UserProfile();
		entity.setUsername(username);
		entity.setRole(role);
		entity.setPreferences(dto.getPreferences());
		
		UserProfile savedEntity = userProfileRepository.save(entity);
		
		return UserProfileMapper.toDto(savedEntity);
	}

	@Override
	public UserProfileDto updateUserProfile(Long id, UserProfileDto dto) {
		UserProfile existingEntity = userProfileRepository.findById(id)
				.orElseThrow(()->
						new ResourceNotFoundException(
								"User Profile not found with ID: "+id));
		existingEntity.setPreferences(dto.getPreferences());
		UserProfile updateEntity = userProfileRepository.save(existingEntity);
		
		return UserProfileMapper.toDto(updateEntity);
	}
	
	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public String deleteUserProfile(Long id) {
		UserProfile entity = userProfileRepository.findById(id)
				.orElseThrow(()->
						new ResourceNotFoundException(
								"User Profile not found with ID: "+id));
		userProfileRepository.delete(entity);
		
		return "Deleted Successfully";
	}
	
	
}