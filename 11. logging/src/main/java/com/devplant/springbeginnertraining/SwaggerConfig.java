package com.devplant.springbeginnertraining;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// tells Spring this is a @Configuration class; runs during startup
@Configuration
// adds Swagger2 to the Spring application context
@EnableSwagger2
public class SwaggerConfig {

	// marks this Docket as a Spring bean; swagger will look for one
	@Bean
	public Docket api() {
		// the Docket is a builder for the swagger app
		return new Docket(DocumentationType.SWAGGER_2).select() // create the builder object
				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class)) // what APIs to map
				.paths(PathSelectors.any()) // what paths
				.build();
	}
}