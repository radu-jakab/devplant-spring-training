package com.devplant.springbeginnertraining.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.devplant.springbeginnertraining.model.Author;
import com.devplant.springbeginnertraining.model.Book;

// mark as component, so that the Spring application context will pick it up
@Component
// Spring Boot interface used to run stuff when loaded in the Spring Context
public class DataInitializer implements CommandLineRunner {

	// inject these beans that we will need
	@Autowired
	private AuthorService authorService;

	// inject these beans that we will need
	@Autowired
	private BooksService bookService;

	@Override
	public void run(String... arg0) throws Exception {
		// note ID's can be whatever, JPA will decide them based on @GeneratedValue
		// Author kate = new Author(0, "Kate", "Kate's life", null);
		// Author johnny = new Author(0, "Johnny", "Johhny's life", null);

		Author kate = Author.builder().name("Kate").bio("Kate's life").build();
		Author johnny = Author.builder().name("Johnny").bio("Johhny's life").build();

		authorService.create(kate);
		authorService.create(johnny);

		bookService.create(Book.builder().title("Kate's novel").shortDescription("Worked so hard for it...").author(kate).build());
		bookService.create(Book.builder().title("Kate's second novel").shortDescription("Already easier!").author(kate).build());
		bookService.create(Book.builder().title("Johnny's novel").shortDescription("I should have been a pianter").author(johnny).build());
	}
}
