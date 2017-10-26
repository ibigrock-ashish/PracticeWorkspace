package com.stackroute.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.stackroute.kafka.model.Model;
 
@Component
public class KafkaConsumer1 {
	private static final Logger log = LoggerFactory.getLogger(KafkaProducer.class);
	
	@Autowired
	Model model;
	
	@KafkaListener(topics="${topic}")
    public void processMessage(String content) {
		log.info("received content = '{}'", content);
		model.setValue(content);
		//System.out.println(content);
    }
}