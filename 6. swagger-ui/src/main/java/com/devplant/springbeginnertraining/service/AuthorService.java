package com.devplant.springbeginnertraining.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.model.Author;
import com.devplant.springbeginnertraining.model.Book;

//tells Spring that this is a component (bean)
@Service
public class AuthorService {

	// create some static objects to play with
	public static final Author AUTHOR1 = new Author(1, "Scooby Doo", "Shaggy's BFF", null);
	public static final Author AUTHOR2 = new Author(2, "Fred Flintstone", "Strong as a rock!", null);
	public static final Book BOOK1 = new Book(1, "Shaggy's BFF", "A ruff novel", AUTHOR1);
	public static final Book BOOK2 = new Book(2, "A dog's life", "Some other ruff novel", AUTHOR1);
	public static final Book BOOK3 = new Book(3, "Rock bottom", "You know, that's life...", AUTHOR2);

	// a list to hold all authors
	public static final List<Author> AUTHORS = new ArrayList<>();

	// circular reference requires Book objects to be created
	static {
		AUTHOR1.setBooks(Arrays.asList(BOOK1, BOOK2));
		AUTHOR2.setBooks(Arrays.asList(BOOK3));
		AUTHORS.add(AUTHOR1);
		AUTHORS.add(AUTHOR2);
	}

	/**
	 * Returns the author with the given id, or null if none is found
	 */
	public Author getOne(long id) {
		for (Author author : AUTHORS) {
			if (author.getId() == id)
				return author;
		}
		return null;
	}

	/**
	 * Returns all authors
	 */
	public List<Author> getAll() {
		return new ArrayList<>(AUTHORS);
	}

	/**
	 * Creates an author based on the entity provided. Returns the author created
	 */
	public Author create(Author author) {
		author.setId(AUTHORS.size() + 1);
		AUTHORS.add(author);
		return author;
	}

	/**
	 * Updates an author based on the entity provided, assuming an author with the
	 * same id exists. Returns the author if the ID was matched, or null otherwise
	 */
	public Author update(Author author) {
		Author existing = getOne(author.getId());
		if (existing == null)
			return null;

		existing.setBio(author.getBio());
		existing.setName(author.getName());
		existing.setBooks(author.getBooks());

		return existing;
	}

	/**
	 * Deletes the author with the given id. Returns false if an author was not
	 * found, and true if an author was found and deleted
	 */
	public boolean delete(long id) {
		Author existing = getOne(id);
		if (existing == null)
			return false;

		AUTHORS.remove(existing);
		return true;
	}
}
