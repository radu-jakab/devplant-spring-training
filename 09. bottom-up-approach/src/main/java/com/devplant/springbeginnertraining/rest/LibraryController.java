package com.devplant.springbeginnertraining.rest;

import java.util.Map;

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

@RestController
@RequestMapping("library")
@ResponseBody
public class LibraryController {

	@Autowired
	private LibraryService libraryService;

	@GetMapping
	public Map<Book, Integer> getAllBooksAndStocks() {
		return libraryService.getAllBooksAndStocks();
	}

	@PutMapping("updateStocks")
	public void changeStocks(@RequestBody Book book, @RequestParam("newStock") int newStock) {
		libraryService.changeStocks(book, newStock);
	}

	@PutMapping("lendBook")
	public Lending lendBook(@RequestBody Lending lending) {
		return libraryService.lendBook(lending.getBook(), lending.getClientName(), lending.getDueReturnDate());
	}

	@PutMapping("returnBook")
	public void returnBook(@RequestParam("lendingId") long lendingId) {
		libraryService.returnBook(lendingId);
	}
}
