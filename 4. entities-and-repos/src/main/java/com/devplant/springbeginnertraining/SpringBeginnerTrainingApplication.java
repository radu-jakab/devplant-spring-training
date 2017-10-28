package com.devplant.springbeginnertraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBeginnerTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBeginnerTrainingApplication.class, args);
	}

	@RequestMapping("/hello")
	public String helloWorld() {
		return "Hello World!";
	}
}
