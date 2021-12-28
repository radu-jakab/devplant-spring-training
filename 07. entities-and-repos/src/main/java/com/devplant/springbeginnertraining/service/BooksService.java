package com.devplant.springbeginnertraining.service;

import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.repo.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//tells Spring that this is a component (bean)
@Service
@RequiredArgsConstructor
public class BooksService {

    private final BookRepository bookRepo;

    /**
     * Returns the book with the given id, or null if none is found
     */
    public Book getOne(long id) {
        return bookRepo.getById(id);
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
        if (bookRepo.existsById(book.getId()))
            throw new IllegalArgumentException("Book already exists");

        return update(book);
    }

    /**
     * Updates a book based on the entity provided, assuming a book with the same id
     * exists. Returns the book if the ID was matched, or null otherwise
     */
    public Book update(Book book) {
        return bookRepo.save(book);
    }

    /**
     * Deletes the book with the given id. Returns false if a book was not found,
     * and true if a book was found and deleted
     */
    public boolean delete(long id) {
        if (bookRepo.existsById(id)) {
            bookRepo.deleteById(id);
            return true;
        }

        return false;
    }
}