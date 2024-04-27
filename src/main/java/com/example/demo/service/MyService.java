package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.dto.User;

@Service
public class MyService {

	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public void sendMessage(User user) {
		//this.kafkaTemplate.send("karuna",user);
		
		//sending message to particular partiton
		this.kafkaTemplate.send("JavaTopic",1, null, user);
		this.kafkaTemplate.send("JavaTopic",0, null, user);
		this.kafkaTemplate.send("JavaTopic",2, null, user);
		this.kafkaTemplate.send("JavaTopic",0, null, user);
		this.kafkaTemplate.send("JavaTopic",2, null, user);
	}
}
