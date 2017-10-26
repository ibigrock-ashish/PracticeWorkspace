package com.stackroute.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.kafka.model.Model;
import com.stackroute.kafka.services.KafkaConsumer1;
import com.stackroute.kafka.services.KafkaProducer;
 
@RestController
@RequestMapping(value="/kafka")
public class WebRestController {
	
	@Autowired
	KafkaProducer producer;
	
	@Autowired
	KafkaConsumer1 consumer;
	
	@Autowired
	Model model;
	
	@GetMapping(value="/producer")
	public String producer(@RequestParam("data")String data){
		producer.send(data);
		
		return "Done";
	}
	
	@GetMapping(value="/consumer")
	public String getAllRecievedMessage(){
		//storage.clear();
		String messages = model.getValue();
		System.out.println(messages);
		
		return messages;
	}
}