package com.devplant.springbeginnertraining.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.model.Author;
import com.devplant.springbeginnertraining.repo.AuthorRepository;
import com.devplant.springbeginnertraining.repo.BookRepository;

//tells Spring that this is a component (bean)
@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepo;

	@Autowired
	private BookRepository bookRepo;

	/**
	 * Returns the author with the given id, or null if none is found
	 */
	public Author getOne(long id) {
		return authorRepo.findOne(id);
	}

	/**
	 * Returns all authors
	 */
	public List<Author> getAll() {
		return authorRepo.findAll();
	}

	/**
	 * Creates an author based on the entity provided. Returns the author created
	 */
	public Author create(Author author) {
		if (authorRepo.exists(author.getId()))
			throw new IllegalArgumentException("Author already exists");

		return update(author);
	}

	/**
	 * Updates an author based on the entity provided, assuming an author with the
	 * same id exists. Returns the author if the ID was matched, or null otherwise
	 */
	public Author update(Author author) {
		if (author.getBooks() != null) {
			author.getBooks().forEach(book -> {
				bookRepo.findOne(book.getId()).setAuthor(author);
			});
		}

		return authorRepo.save(author);
	}

	/**
	 * Deletes the author with the given id. Returns false if an author was not
	 * found, and true if an author was found and deleted
	 */
	public boolean delete(long id) {
		if (authorRepo.exists(id)) {
			authorRepo.delete(id);
			return true;
		}

		return false;
	}
}
