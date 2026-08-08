package com.example.auditservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.example.auditservice.entity.AuditLog;
import com.example.auditservice.event.AuditEvent;
import com.example.auditservice.repository.AuditRepository;

@Component
public class AuditConsumer {
	@Autowired
	private AuditRepository auditRepository;
	
	@KafkaListener(
			topics = "car-service-audit-topic",
			groupId = "audit-group")
	public void consume(AuditEvent event) {
		System.out.println("Received Event : "+event);
		
		AuditLog auditLog = new AuditLog();
		
		auditLog.setCarServiceId(event.getCarServiceId());
		auditLog.setAction(event.getAction());
		auditLog.setPerformedBy(event.getPerformedBy());
		auditLog.setPerformedByRole(event.getPerformedByRole());
		auditLog.setDetails(event.getDetails());
		
		auditRepository.save(auditLog);
		System.out.println("Audit Log Saved Successfully");
		
	}
}
