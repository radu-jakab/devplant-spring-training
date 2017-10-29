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

7. Entities and repos
- create packages model and repo
- maven dependencies: spring-boot-starter-data-jpa, h2
- H2 in-memory database
- author, book entities
- author, book repos

8. The bottom-up approach
- Library entity and repo, services and controller

9. Seeding data
- commandline runner
- seedData.sql

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
