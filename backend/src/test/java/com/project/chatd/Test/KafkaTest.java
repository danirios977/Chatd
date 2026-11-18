package com.project.chatd.Test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootTest
public class KafkaTest {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	
	@Test
	void testEnviarMensaje() {
		
		this.kafkaTemplate.send("mi-topico-prueba", "Mensaje de prueba desde JUnit");
		
		System.out.println("Test ejecutado y mensaje enviado a Docker con éxito.");
	}
}
