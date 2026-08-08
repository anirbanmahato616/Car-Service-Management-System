package com.example.userprofileservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userprofileservice.entity.UserProfile;

@Repository
public interface UserProfileRepository
        extends JpaRepository<UserProfile, Long> {

}