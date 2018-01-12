package com.devplant.springbeginnertraining.service;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.dto.BookStockDTO;
import com.devplant.springbeginnertraining.exceptions.LibraryException;
import com.devplant.springbeginnertraining.mapper.BookStockMapper;
import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.model.Lending;
import com.devplant.springbeginnertraining.model.Library;
import com.devplant.springbeginnertraining.repo.LendingRepository;
import com.devplant.springbeginnertraining.repo.LibraryRepository;

@Service
public class LibraryService {

	public static final long LIBRARY_ID = 1;

	@Autowired
	BookStockMapper bookStockMapper;

	@Autowired
	private MessagesService messages;

	@Autowired
	private BooksService booksService;

	@Autowired
	private LibraryRepository libraryRepo;

	@Autowired
	private LendingRepository lendingRepo;

	public List<BookStockDTO> getAllBooksAndStocks() {
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new IllegalArgumentException(messages.getMessage("library.error.missing", LIBRARY_ID));

		Map<Book, Integer> stocks = lib.getStocks();

		return stocks.keySet().stream().map((book) -> {
			return bookStockMapper.getAsBookStock(book, stocks.get(book));
		}).collect(Collectors.toList());
	}

	public void changeStocks(Book book, int newStock) {
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new LibraryException(messages.getMessage("library.error.missing", LIBRARY_ID));

		lib.getStocks().put(book, newStock);
		libraryRepo.save(lib);
	}

	public Lending lendBook(Book book, String clientName, LocalDate dueDate) {
		// check clientName and dueDate are valid
		if (clientName == null || clientName.isEmpty())
			throw new LibraryException(messages.getMessage("library.error.clientName"));
		if (dueDate == null || dueDate.isBefore(LocalDate.now()))
			throw new LibraryException(messages.getMessage("library.error.dueDate"));

		// check if the book exists; use the repo one
		Book bookEntity = booksService.getOne(book.getId());
		if (bookEntity == null)
			throw new LibraryException(messages.getMessage("library.error.missingBookId", book.getId()));

		// check if we have it on stock
		Library lib = libraryRepo.findOne(LIBRARY_ID);
		if (lib == null)
			throw new LibraryException(messages.getMessage("library.error.missing", LIBRARY_ID));
		if (lib.getStocks().get(bookEntity) <= 0)
			throw new LibraryException(messages.getMessage("library.error.stockDepleted", book.getTitle()));

		// decrease the available stock
		int quantity = lib.getStocks().get(bookEntity);
		lib.getStocks().put(bookEntity, quantity - 1);
		libraryRepo.save(lib);

		// create lending record
		Lending result = Lending.builder().id(0).book(bookEntity).lendingTime(ZonedDateTime.now()).dueReturnDate(dueDate).clientName(clientName).library(lib)
				.build();

		return result;
	}

	public void returnBook(long lendingId) {
		Lending lending = lendingRepo.findOne(lendingId);
		if (lending == null)
			throw new LibraryException(messages.getMessage("library.error.lendingId", lendingId));
		if (lending.getBook() == null)
			throw new LibraryException(messages.getMessage("library.error.lending.noBook"));
		if (lending.getLibrary() == null)
			throw new LibraryException(messages.getMessage("library.error.lending.noLibrary"));

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
