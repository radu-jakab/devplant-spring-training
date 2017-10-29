# DevPlant's basic-level Spring Boot training

## Topics
0. Pre-requisites
- use IntelliJ for and IDE if possible
- have Java 8, maven, npm installed

- discuss HTTP, AOP, Java Reflection

1. Spring initializr
- Create a project using https://start.spring.io

2. Hello world

3. devplant.library requirements
- what the final application will look like
- data structure
- functional requirements

4. Controllers
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
- Lending entity and repo, services and controller; methods: show all lendings, show all lendings for client
- Library entity and repo, services and controller; methods: show all books, lend book, return book
- remove DataInitializer, create library record, some authors and books in seedData.sql 
- @Transactional
- JPQL

10. Logging

10. Validation

10. Converters
- DTOs and MapStruct

11. Spring Profiles

12. Security Configuration
- authenticated(), adding users
- endpoint authorization config
- CSRF attacks
- JDBC userstore

13. Adding the GUI app

14. Error handling

15. Async operations, Spring scheduler

16. Stuff that cool kids also do
- elastic search repos
- docker integration
-
