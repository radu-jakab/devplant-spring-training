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

import com.devplant.springbeginnertraining.model.Author;

//tells Spring this class defines REST endpoints
@RestController
// all defined endpoints will have the common root "/author"
@RequestMapping("author")
// annotates all methods with @ResponseBody, making their return value define
// the body of the HTTP response
@ResponseBody
public class AuthorController {

	/**
	 * Creates an HTTP GET mapping on "/author/{id}", that returns the author entity
	 * for the given ID, or an error status code if no such entity was found
	 * 
	 * @param id
	 *            the id of the author that is looked up
	 * @return the author with the given ID, or HTTP 404 error if not found
	 */
	@GetMapping("/{id}")
	public ResponseEntity<Author> getOne(@PathVariable("id") long id) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP GET mapping on "/author", that returns the full list of all
	 * authors in the system
	 * 
	 * @return a list of all the authors in the system
	 */
	@GetMapping()
	public ResponseEntity<List<Author>> getAll() {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP POST mapping on "/author/add", that allows the creation of an
	 * Author entity based on request body JSON
	 * 
	 * @param author
	 *            a JSON that can be mapped to a
	 *            com.devplant.springbeginnertraining.model.Author
	 * @return the author entity created
	 */
	@PostMapping("/add")
	public ResponseEntity<Author> create(@RequestBody Author author) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP PUT mapping on "/author/update", that allows the update of an
	 * Author entity based on request body JSON
	 * 
	 * @param author
	 *            a JSON that can be mapped to a
	 *            com.devplant.springbeginnertraining.model.Author
	 * @return the author entity updated, or HTTP 404 error if not found
	 */
	@PutMapping("/update")
	public ResponseEntity<Author> update(@RequestBody Author author) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}

	/**
	 * Creates an HTTP DELETE mapping on "/author/delete", that deletes an author
	 * for a given id.<br/>
	 * The ID is passed as request param, so it would look like
	 * "/author/delete?id=3"
	 * 
	 * @param id
	 *            the id of the author to be deleted
	 * @return HTTP 200 if successful, or HTTP 404 error if not found
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam("id") long id) {
		// TODO does nothing yet, returns HTTP 200 always
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
