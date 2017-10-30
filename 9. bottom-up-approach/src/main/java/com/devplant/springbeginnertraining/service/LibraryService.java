package com.devplant.springbeginnertraining.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.model.Lending;
import com.devplant.springbeginnertraining.model.Library;
import com.devplant.springbeginnertraining.repo.LendingRepository;
import com.devplant.springbeginnertraining.repo.LibraryRepository;

@Service
public class LibraryService {

	public static final long LIBRARY_ID = 1;

	@Autowired
	private BooksService booksService;

	@Autowired
	private LibraryRepository libraryRepo;

	@Autowired
	private LendingRepository lendingRepo;

	public Map<Book, Integer> getAllBooksAndStocks() {
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new IllegalArgumentException("Library not found");

		return lib.getStocks();
	}

	public void changeStocks(Book book, int newStock) {
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new IllegalArgumentException("Library not found");

		lib.getStocks().put(book, newStock);
		libraryRepo.save(lib);
	}

	public Lending lendBook(Book book, String clientName, LocalDate dueDate) {
		// check clientName and dueDate are valid
		if (clientName == null || clientName.isEmpty())
			throw new IllegalArgumentException("No client name supplied!");
		if (dueDate == null || dueDate.isBefore(LocalDate.now()))
			throw new IllegalArgumentException("Invalid due date!");

		// check if the book exists; use the repo one
		book = booksService.getOne(book.getId());
		if (book == null)
			throw new IllegalArgumentException("This book does not exist!");

		// check if we have it on stock
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new IllegalArgumentException("Library not found");
		if (lib.getStocks().get(book) <= 0)
			throw new RuntimeException("Book stock depleted!");

		// decrease the available stock
		int quantity = lib.getStocks().get(book);
		lib.getStocks().put(book, quantity - 1);
		libraryRepo.save(lib);

		// create lending record
		return lendingRepo.save(new Lending(0, book, ZonedDateTime.now(), dueDate, clientName, lib));
	}

	public void returnBook(long lendingId) {
		Lending lending = lendingRepo.findOne(lendingId);
		if (lending == null)
			throw new IllegalArgumentException("Lending record not found!");
		if (lending.getBook() == null)
			throw new IllegalArgumentException("Book not found on lending record!");
		if (lending.getLibrary() == null)
			throw new IllegalArgumentException("Library not found on lending record!");

		Book book = lending.getBook();
		Library lib = lending.getLibrary();

		// increase the available stock
		int quantity = lib.getStocks().get(book);
		lib.getStocks().put(book, quantity + 1);
		libraryRepo.save(lib);

		// delete the lending
		lendingRepo.delete(lendingId);
	}
}
