package com.microservices.login;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	
	@Value("${greetings.message}")
	private String greetings;
	
	
	@GetMapping("/greeting")
	public String greetings() {
	
		return greetings;
	}

}
