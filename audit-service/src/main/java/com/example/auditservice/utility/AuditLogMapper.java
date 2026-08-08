package com.example.auditservice.utility;

import java.util.List;
import java.util.stream.Collectors;

import com.example.auditservice.dto.AuditLogDto;
import com.example.auditservice.entity.AuditLog;


public class AuditLogMapper {
	public static AuditLogDto toDto(AuditLog entity) {
		AuditLogDto dto = new AuditLogDto();
		
		dto.setId(entity.getId());
		dto.setCarServiceId(entity.getCarServiceId());
		dto.setAction(entity.getAction());
		dto.setTimestamp(entity.getTimestamp());
		dto.setPerformedBy(entity.getPerformedBy());
		dto.setPerformedByRole(entity.getPerformedByRole());
		dto.setDetails(entity.getDetails());
		
		return dto;
	}
	
	public static List<AuditLogDto> toDtoList(List<AuditLog> entityList){
		return entityList.stream().map(entity -> toDto(entity)).collect(Collectors.toList());
	}
}
