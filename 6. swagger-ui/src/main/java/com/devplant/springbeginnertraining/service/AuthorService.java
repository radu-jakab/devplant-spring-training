package com.devplant.springbeginnertraining.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.model.Author;
import com.devplant.springbeginnertraining.model.Book;

// tells Spring that this is a component (bean)
@Service
public class AuthorService {

	// create some static objects to play with
	public static final Author AUTHOR1 = Author.builder().id(1).name("Scooby Doo").bio("The detective dog").build();
	public static final Author AUTHOR2 = Author.builder().id(1).name("Fred Flintstone").bio("Strong as a rock!").build();
	public static final Book BOOK1 = Book.builder().id(1).title("Shaggy's BFF").shortDescription("A ruff novel").author(AUTHOR1).build();
	public static final Book BOOK2 = Book.builder().id(1).title("A dog's life").shortDescription("Some other ruff novel").author(AUTHOR1).build();
	public static final Book BOOK3 = Book.builder().id(1).title("Rock bottom").shortDescription("You know, that's life...").author(AUTHOR2).build();

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
	 * Updates an author based on the entity provided, assuming an author with the same id exists. Returns the author if the ID was matched, or null otherwise
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
	 * Deletes the author with the given id. Returns false if an author was not found, and true if an author was found and deleted
	 */
	public boolean delete(long id) {
		Author existing = getOne(id);
		if (existing == null)
			return false;

		AUTHORS.remove(existing);
		return true;
	}
}
