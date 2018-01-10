package com.devplant.springbeginnertraining.rest;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.model.Lending;
import com.devplant.springbeginnertraining.service.LibraryService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("library")
@ResponseBody
// log4j capability added via lombok
@Slf4j
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@GetMapping
	public Map<Book, Integer> getAllBooksAndStocks() {
		log.debug("REST call - getting all books and stocks");

		return libraryService.getAllBooksAndStocks();
	}

	@PutMapping("updateStocks")
	public void changeStocks(@RequestBody Book book, @RequestParam("newStock") int newStock) {
		log.debug("REST call - new stock is {} for book {}", newStock, book);

		libraryService.changeStocks(book, newStock);
	}

	@PutMapping("lendBook")
	public Lending lendBook(@Valid @RequestBody Lending lending) {
		log.debug("REST call - lending book: {}", lending);

		return libraryService.lendBook(lending.getBook(), lending.getClientName(), lending.getDueReturnDate());
	}

	@PutMapping("returnBook")
	public void returnBook(@RequestParam("lendingId") long lendingId) {
		log.debug("REST call - returning book for lending id {}", lendingId);

		libraryService.returnBook(lendingId);
	}
}
