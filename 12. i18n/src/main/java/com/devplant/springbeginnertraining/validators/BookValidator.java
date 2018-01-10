package com.devplant.springbeginnertraining.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.service.MessagesService;

/**
 * A validator for our books; provides checks for title and author
 * 
 * @author RJA
 */
@Component
public class BookValidator {

	@Autowired
	private MessagesService messages;

	public void validate(Book book) {
		checkTitle(book);
		checkAuthor(book);
	}

	public void checkTitle(Book book) {
		if (book.getTitle() == null || book.getTitle().isEmpty())
			throw new IllegalArgumentException(messages.getMessage("book.error.title.missing"));
	}

	public void checkAuthor(Book book) {
		if (book.getAuthor() == null)
			throw new IllegalArgumentException(messages.getMessage("book.error.author.missing"));
	}
}
