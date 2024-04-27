package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.User;
import com.example.demo.service.MyService;

@Controller
public class MyController {
	
	@Autowired
	public MyService service;
	
	@PostMapping("/sendUser")
	public ResponseEntity<String> sendMessage(@RequestBody User user) {
		this.service.sendMessage(user);
		return new ResponseEntity<String>("Successfully Sent",HttpStatus.ACCEPTED);
	}
}
