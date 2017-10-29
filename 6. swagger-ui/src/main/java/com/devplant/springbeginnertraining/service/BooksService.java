package com.devplant.springbeginnertraining.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.model.Book;

//tells Spring that this is a component (bean)
@Service
public class BooksService {

	// a list to hold all books
	public static final List<Book> BOOKS = new ArrayList<>();

	static {
		BOOKS.add(AuthorService.BOOK1);
		BOOKS.add(AuthorService.BOOK2);
		BOOKS.add(AuthorService.BOOK3);
	}

	/**
	 * Returns the book with the given id, or null if none is found
	 */
	public Book getOne(long id) {
		for (Book book : BOOKS) {
			if (book.getId() == id)
				return book;
		}
		return null;
	}

	/**
	 * Returns all books
	 */
	public List<Book> getAll() {
		return new ArrayList<>(BOOKS);
	}

	/**
	 * Creates a book based on the entity provided. Returns the book created
	 */
	public Book create(Book book) {
		book.setId(BOOKS.size() + 1);
		BOOKS.add(book);
		return book;
	}

	/**
	 * Updates a book based on the entity provided, assuming a book with the same id
	 * exists. Returns the book if the ID was matched, or null otherwise
	 */
	public Book update(Book book) {
		Book existing = getOne(book.getId());
		if (existing == null)
			return null;

		existing.setTitle(book.getTitle());
		existing.setShortDescription(book.getShortDescription());
		existing.setAuthor(book.getAuthor());

		return existing;
	}

	/**
	 * Deletes the book with the given id. Returns false if a book was not found,
	 * and true if a book was found and deleted
	 */
	public boolean delete(long id) {
		Book existing = getOne(id);
		if (existing == null)
			return false;

		BOOKS.remove(existing);
		return true;
	}
}
