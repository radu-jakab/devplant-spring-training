package com.devplant.springbeginnertraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.exceptions.LibraryException;
import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.repo.BookRepository;
import com.devplant.springbeginnertraining.validators.BookValidator;

// tells Spring that this is a component (bean)
@Service
public class BooksService {

	@Autowired
	private MessagesService messages;

	@Autowired
	private BookValidator bookValidator;

	@Autowired
	private BookRepository bookRepo;

	/**
	 * Returns the book with the given id, or null if none is found
	 */
	public Book getOne(long id) {
		return bookRepo.findOne(id);
	}

	/**
	 * Returns all books
	 */
	public List<Book> getAll() {
		return bookRepo.findAll();
	}

	/**
	 * Creates a book based on the entity provided. Returns the book created
	 */
	public Book create(Book book) {
		// validate
		bookValidator.validate(book);

		// create
		if (bookRepo.exists(book.getId()))
			throw new LibraryException(messages.getMessage("book.error.alreadyExists", book.getId()));

		return update(book);
	}

	/**
	 * Updates a book based on the entity provided, assuming a book with the same id exists. Returns the book if the ID was matched, or null otherwise
	 */
	public Book update(Book book) {
		// validate
		bookValidator.validate(book);

		// update
		return bookRepo.save(book);
	}

	/**
	 * Deletes the book with the given id. Returns false if a book was not found, and true if a book was found and deleted
	 */
	public boolean delete(long id) {
		if (bookRepo.exists(id)) {
			bookRepo.delete(id);
			return true;
		}

		return false;
	}
}
