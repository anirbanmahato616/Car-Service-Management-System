package com.example.userprofileservice.service;

import java.util.List;

import com.example.userprofileservice.dto.UserProfileDto;

public interface UserProfileService {

    public List<UserProfileDto> getAllUserProfile();

    public UserProfileDto createUserProfile(UserProfileDto dto);

    public UserProfileDto updateUserProfile(Long id, UserProfileDto dto);

    public String deleteUserProfile(Long id);

}