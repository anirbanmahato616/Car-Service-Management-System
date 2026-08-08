package com.example.userprofileservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userprofileservice.dto.UserProfileDto;
import com.example.userprofileservice.service.UserProfileService;

// REST Controller for managing User Profile operations
@RestController
@RequestMapping("/userprofile")
public class UserProfileController {

    // Service layer dependency for User Profile business logic
    @Autowired
    private UserProfileService userProfileService;

    // Retrieves all user profiles
    @GetMapping
    public ResponseEntity<List<UserProfileDto>> getAllUserProfile() {
        return ResponseEntity.ok(userProfileService.getAllUserProfile());
    }

    // Creates a new user profile
    @PostMapping("/save")
    public ResponseEntity<UserProfileDto> createUserProfile(
            @RequestBody UserProfileDto dto) {

        return new ResponseEntity<>(
                userProfileService.createUserProfile(dto),
                HttpStatus.CREATED);
    }

    // Updates an existing user profile based on the provided ID
    @PutMapping("/{id}")
    public ResponseEntity<UserProfileDto> updateUserProfile(
            @PathVariable Long id,
            @RequestBody UserProfileDto dto) {

        return new ResponseEntity<>(
                userProfileService.updateUserProfile(id, dto),
                HttpStatus.CREATED);
    }

    // Deletes a user profile by its ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUserProfile(
            @PathVariable Long id) {

        return new ResponseEntity<>(
                userProfileService.deleteUserProfile(id),
                HttpStatus.ACCEPTED);
    }

}