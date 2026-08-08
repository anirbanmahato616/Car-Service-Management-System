package com.example.auditservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auditservice.dto.AuditLogDto;
import com.example.auditservice.service.AuditService;

@RestController
@RequestMapping("/auditservice")
public class AuditController {
	
	@Autowired
	AuditService auditService;
	
	@GetMapping
	public ResponseEntity<List<AuditLogDto>> getAllAuditLogs(){
		return ResponseEntity.ok(auditService.getAllAuditLogs());
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteAuditLog(@PathVariable Long id){
		return new ResponseEntity<>(auditService.deleteAuditLog(id), HttpStatus.ACCEPTED);
	}
}
