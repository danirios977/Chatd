package com.project.chatd.Service;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {
	
	private String TOPIC_NAME = "mi-topico-prueba";
	private KafkaTemplate<String, String> kafkaTemplate;
	
	public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}
	
	public void enviarMensaje(String mensaje) {
		kafkaTemplate.send(TOPIC_NAME, mensaje);
		System.out.println("Mensaje enviado con exito: " + mensaje);
	}
}
