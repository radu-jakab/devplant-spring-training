package com.devplant.springbeginnertraining.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devplant.springbeginnertraining.model.Book;

//tells Spring this class defines REST endpoints
@RestController
// all defined endpoints will have the common root "/book"
@RequestMapping("book")
// annotates all methods with @ResponseBody, making their return value define
// the body of the HTTP response
@ResponseBody
public class BookController {

	/**
	 * Creates an HTTP GET mapping on "/book/{id}", that returns the book entity for
	 * the given ID, or an error status code if no such entity was found
	 * 
	 * @param id
	 *            the id of the book that is looked up
	 * @return the book with the given ID, or HTTP 404 error if not found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Book> getOne(@PathVariable("id") long id) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP GET mapping on "/book", that returns the full list of all
	 * books in the system
	 * 
	 * @return a list of all the books in the system
	 */
	@GetMapping()
	public ResponseEntity<List<Book>> getAll() {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP POST mapping on "/book/add", that allows the creation of a
	 * Book entity based on request body JSON
	 * 
	 * @param book
	 *            a JSON that can be mapped to a
	 *            com.devplant.springbeginnertraining.model.Book
	 * @return the book entity created
	 */
	@PostMapping("/add")
	public ResponseEntity<Book> create(@RequestBody Book book) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP PUT mapping on "/book/update", that allows the update of a
	 * Book entity based on request body JSON
	 * 
	 * @param book
	 *            a JSON that can be mapped to a
	 *            com.devplant.springbeginnertraining.model.Book
	 * @return the book entity updated, or HTTP 404 error if not found
	 */
	@PutMapping("/update")
	public ResponseEntity<Book> update(@RequestBody Book book) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP DELETE mapping on "/book/delete", that deletes a book for a
	 * given id.<br/>
	 * The ID is passed as request param, so it would look like "/book/delete?id=3"
	 * 
	 * @param id
	 *            the id of the book to be deleted
	 * @return HTTP 200 if successful, or HTTP 404 error if not found
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam("id") long id) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
