package com.kalelogistics.main.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
	
	//http://localhost:8080/greet = HTTP-Get
	@GetMapping("greet")
	public String greet() {
		return "Hello World";
	}

	//http://localhost:8080/msg = HTTP-Post
	@PostMapping("msg")
	public String message() {
		return "Spring Boot is simple";
	}
	
	//http://localhost:8080/do = HTTP-Put
	@PutMapping("do")
	public String putMessage() {
		return "Put method called";
	}
	
	@DeleteMapping("show") 
	public String showMessage() {
		return "Delete method called";
	}
}
