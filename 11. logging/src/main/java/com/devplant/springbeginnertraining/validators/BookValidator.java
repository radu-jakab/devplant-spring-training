package com.devplant.springbeginnertraining.validators;

import org.springframework.stereotype.Component;

import com.devplant.springbeginnertraining.model.Book;

/**
 * A validator for our books; provides checks for title and author
 * 
 * @author RJA
 */
@Component
public class BookValidator {

	public void validate(Book book) {
		checkTitle(book);
		checkAuthor(book);
	}

	public void checkTitle(Book book) {
		if (book.getTitle() == null || book.getTitle().isEmpty())
			throw new IllegalArgumentException("Book title is required");
	}

	public void checkAuthor(Book book) {
		if (book.getAuthor() == null)
			throw new IllegalArgumentException("Book author is required");
	}
}
