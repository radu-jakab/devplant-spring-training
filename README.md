# DevPlant's basic-level Spring Boot training

## Topics
0. Pre-requisites
- use IntelliJ for and IDE if possible
- have Java 8, maven, npm, git installed

- discuss HTTP, AOP, Java Reflection
https://code.tutsplus.com/tutorials/http-the-protocol-every-web-developer-must-know-part-1--net-31177
http://www.andrewewhite.net/wordpress/2010/03/17/aspectj-annotation-tutorial/
https://www.sitepoint.com/java-reflection-api-tutorial/


1. Spring initializr
- Create a project using https://start.spring.io

2. Hello world

3. devplant.library requirements
- what the final application will look like
- data structure
- functional requirements

4. Controllers
https://docs.spring.io/spring/docs/3.0.0.M4/reference/html/ch15s02.html
- create package controller
- maven dependencies: lombok
- lombok
- author, book DOs
- author, book CRUD endpoints
- convention over configuration

5. Services
- author, book CRUD operations
- singletons
- faked static objects
- rewrite controllers to use services
- postman

6. Swagger-ui
- maven dependencies: springfox-swagger2, springfox-swagger-ui
- @Configuration class
```
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any())
				.build();
	}
}
```

7. Entities and repos
- maven dependencies: spring-boot-starter-data-jpa, h2
- H2 in-memory database (what it is, configuration)
```
spring:
  jpa:
    show-sql: true
  h2:
    console:
      enabled: true
      path: '/h2-console'
  datasource:
    url: jdbc:h2:mem:spring-app;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    driverClassName: org.h2.Driver
    username: sa
    password: 
    database-platform: org.hibernate.dialect.H2Dialect
```
- author, book as entities
- create package repo
- author, book repos
- @EnableJpaRepositories
- relink services to use the repos

8. Seeding data
- commandline runner
- seedData.sql

9. The bottom-up approach
- @OneToOne, @ElementCollection
- Lending entity and repo, services and controller; methods: show all lendings, show all lendings for client
- Library entity and repo, services and controller; methods: show stocks, change stocks, lend book, return book
- remove DataInitializer, create library record, some authors and books in seedData.sql 
- @Transactional

10. Logging
- add @Slf4j annotation on all controllers
- log entry into every controller endpoint
- set logging.file in application.yml, create /logs folder
- add & configure logback-spring.xml file
- what the log entries look like, how to turn them on & off

11. Validation
http://beanvalidation.org/1.0/spec/
- @NotNull, @NotEmpty, @Size, @Future, @Past
- javax.validation.constraints
- Author.name, 2<length<128
- Author.bio, not null, not empty
- Lending.lendingTime, past
- Lending.dueReturnDate, future
- @Valid on controllers

- create package com.devplant.springbeginnertraining.validators
- BookValidator + BookService, AuthorValidator + AuthorService

- honorable  mention: JSR-303

12. i18n
- add messages.properties files, move strings here
- create a MessageService class, (discuss pros, cons & options)
- in application classes, replace strings with MessageService.getMessage(...)
- add the WebMVCConfig configuration class; configure locale change and messageSource

13. Error handling
- create class GenericErrorHandler, use @ControllerAdvice
- @ExceptionHandler, @ResponseStatus
- create LibraryException
- create ErrorMessageDTO

14. Converters
- DTOs and MapStruct

15. Spring Profiles
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-profiles

16. Caching
http://www.baeldung.com/spring-cache-tutorial

17. Configuration classes
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#using-boot-configuration-classes
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-developing-auto-configuration

18. Security Configuration
- authenticated(), adding users
- endpoint authorization config
- CSRF attacks
- JDBC userstore

read:
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-endpoints

19. Adding the GUI app

20. Unit testing

21. Integration testing

22. Async operations, Spring scheduler

23. Metrics
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#production-ready-metrics

24. Web-sockets
https://docs.spring.io/spring/docs/5.0.3.BUILD-SNAPSHOT/spring-framework-reference/web.html#websocket

25. Stuff that cool kids also do
- elastic search repos
https://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-elasticsearch
- docker integration

