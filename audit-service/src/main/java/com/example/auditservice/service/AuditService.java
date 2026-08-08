package com.example.auditservice.service;

import java.util.List;

import com.example.auditservice.dto.AuditLogDto;

public interface AuditService {
	public List<AuditLogDto> getAllAuditLogs();
	public String deleteAuditLog(Long id); 
}
