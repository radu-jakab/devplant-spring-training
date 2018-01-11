package com.devplant.springbeginnertraining.validators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.devplant.springbeginnertraining.exceptions.LibraryException;
import com.devplant.springbeginnertraining.model.Author;
import com.devplant.springbeginnertraining.service.MessagesService;

/**
 * A validator for our books; provides checks for title and author
 * 
 * @author RJA
 */
@Component
public class AuthorValidator {
	@Autowired
	private MessagesService messages;

	public void validate(Author author) {
		checkName(author);
		checkBio(author);
	}

	public void checkName(Author author) {
		if (author.getName() == null || author.getName().isEmpty())
			throw new LibraryException(messages.getMessage("author.error.name.missing"));
		if (author.getName().length() < 2)
			throw new LibraryException(messages.getMessage("author.error.name.min2"));
		if (author.getName().length() > 128)
			throw new LibraryException(messages.getMessage("author.error.name.max128"));
	}

	public void checkBio(Author author) {
		if (author.getBio() == null || author.getBio().isEmpty())
			throw new LibraryException(messages.getMessage("author.error.bio.missing"));
	}
}
