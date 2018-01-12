package com.devplant.springbeginnertraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

// configuration annotation that marks this as a runnable Spring Boot application
@SpringBootApplication
// allow JPA repos
@EnableJpaRepositories
@EnableCaching
public class SpringBeginnerTrainingApplication {

	// Spring runs as a standalone java application, started using a "main" method
	public static void main(String[] args) {

		// tells Spring to start all configured components
		SpringApplication.run(SpringBeginnerTrainingApplication.class, args);
	}
}
