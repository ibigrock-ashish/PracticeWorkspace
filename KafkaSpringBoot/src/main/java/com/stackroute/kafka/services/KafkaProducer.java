package com.stackroute.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	@Value("${topic}")
	String kafkaTopic;

	public void send(String data) {
		log.info("sending data='{}'", data);
		// System.out.println("Data : " + data);

		// System.out.println("Topic : " + kafkaTopic);
		kafkaTemplate.send(kafkaTopic, data);
	}
}
