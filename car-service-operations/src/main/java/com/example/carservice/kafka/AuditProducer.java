package com.example.carservice.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.carservice.event.AuditEvent;

@Service
public class AuditProducer {
	private static final String TOPIC = "car-service-audit-topic";
	
	private final KafkaTemplate<String, AuditEvent> kafkaTemplate;

	public AuditProducer(KafkaTemplate<String, AuditEvent> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void publishEvent(AuditEvent event) {
		kafkaTemplate.send(TOPIC, event);
	}
}
