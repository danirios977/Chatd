package com.project.chatd.config;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.Serializer;
import org.junit.jupiter.api.Test;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.test.util.ReflectionTestUtils;

class KafkaConfigTest {

	@Test
	void producerFactoryUsesKafkaStringSerializer() {
		KafkaConfig config = new KafkaConfig();
		ReflectionTestUtils.setField(config, "bootstrapServers", "localhost:29092");

		ProducerFactory<String, String> factory = config.producerFactory();

		assertKafkaSerializer(factory.getConfigurationProperties().get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG));
		assertKafkaSerializer(factory.getConfigurationProperties().get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG));
	}

	private static void assertKafkaSerializer(Object configured) {
		assertTrue(configured instanceof Class<?> serializerClass && Serializer.class.isAssignableFrom(serializerClass),
				() -> "expected a Kafka Serializer, got " + configured);
	}
}
