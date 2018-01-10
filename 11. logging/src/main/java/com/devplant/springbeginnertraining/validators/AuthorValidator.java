package com.devplant.springbeginnertraining.validators;

import org.springframework.stereotype.Component;

import com.devplant.springbeginnertraining.model.Author;

/**
 * A validator for our books; provides checks for title and author
 * 
 * @author RJA
 */
@Component
public class AuthorValidator {
	public void validate(Author author) {
		checkName(author);
		checkBio(author);
	}

	public void checkName(Author author) {
		if (author.getName() == null || author.getName().isEmpty())
			throw new IllegalArgumentException("Author name is required");
		if (author.getName().length() < 2)
			throw new IllegalArgumentException("Author name must have at least 2 characters");
		if (author.getName().length() > 128)
			throw new IllegalArgumentException("Author name cannot be longer than 128 characters");
	}

	public void checkBio(Author author) {
		if (author.getBio() == null || author.getBio().isEmpty())
			throw new IllegalArgumentException("Author bio is required");
	}
}
