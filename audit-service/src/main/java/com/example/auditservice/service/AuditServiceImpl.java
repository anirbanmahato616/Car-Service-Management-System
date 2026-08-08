package com.example.auditservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.example.auditservice.dto.AuditLogDto;
import com.example.auditservice.entity.AuditLog;
import com.example.auditservice.exception.ResourceNotFoundException;
import com.example.auditservice.repository.AuditRepository;
import com.example.auditservice.utility.AuditLogMapper;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuditServiceImpl implements AuditService{
	@Autowired
	AuditRepository auditRepository;

	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public List<AuditLogDto> getAllAuditLogs() {
		List<AuditLog> entityList = auditRepository.findAll();
		return AuditLogMapper.toDtoList(entityList);
	}

	@PreAuthorize("hasAnyAuthority('ADMIN', 'SERVICE_MANAGER')")
	@Override
	public String deleteAuditLog(Long id) {
		AuditLog entity = auditRepository.findById(id)
				.orElseThrow(()->
						new ResourceNotFoundException(
								"Audit Log not found with ID: "+id));
		auditRepository.delete(entity);
		return "Deleted Successfully";
	}
	
	
}
