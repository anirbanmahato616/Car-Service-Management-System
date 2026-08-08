package com.example.auditservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.auditservice.entity.AuditLog;

@Repository
public interface AuditRepository extends JpaRepository<AuditLog,Long>{
	
}
