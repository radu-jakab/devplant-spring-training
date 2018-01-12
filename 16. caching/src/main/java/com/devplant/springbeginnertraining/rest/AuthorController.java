package com.devplant.springbeginnertraining.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
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
import com.devplant.springbeginnertraining.service.AuthorService;

import lombok.extern.slf4j.Slf4j;

//tells Spring this class defines REST endpoints
@RestController
// all defined endpoints will have the common root "/author"
@RequestMapping("author")
// annotates all methods with @ResponseBody, making their return value define
// the body of the HTTP response
@ResponseBody
// log4j capability added via lombok
@Slf4j
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	/**
	 * Creates an HTTP GET mapping on "/author/{id}", that returns the author entity for the given ID, or an error status code if no such entity was found
	 * 
	 * @param id
	 *            the id of the author that is looked up
	 * @return the author with the given ID, or HTTP 404 error if not found
	 */
	@GetMapping("/{id}")
	@Cacheable("author")
	public ResponseEntity<Author> getOne(@PathVariable("id") long id) {
		log.debug("REST call - getting one author with id {}", id);

		// use the service to do the work
		Author result = authorService.getOne(id);

		// create the response depending on the result
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Creates an HTTP GET mapping on "/author", that returns the full list of all authors in the system
	 * 
	 * @return a list of all the authors in the system
	 */
	@GetMapping()
	@Cacheable(value="all_authors", key="1")
	public ResponseEntity<List<Author>> getAll() {
		log.debug("REST call - getting all authors");

		// use the service to do the work
		List<Author> authors = authorService.getAll();
		return new ResponseEntity<>(authors, HttpStatus.OK);
	}

	/**
	 * Creates an HTTP POST mapping on "/author/add", that allows the creation of an Author entity based on request body JSON
	 * 
	 * @param author
	 *            a JSON that can be mapped to a com.devplant.springbeginnertraining.model.Author
	 * @return the author entity created
	 */
	@PostMapping("/add")
	@CacheEvict(value="all_authors", key="1")
	public ResponseEntity<Author> create(@Valid @RequestBody Author author) {
		log.debug("REST call - adding author: {}", author);

		// use the service to do the work
		Author result = authorService.create(author);

		// create the response
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	/**
	 * Creates an HTTP PUT mapping on "/author/update", that allows the update of an Author entity based on request body JSON
	 * 
	 * @param author
	 *            a JSON that can be mapped to a com.devplant.springbeginnertraining.model.Author
	 * @return the author entity updated, or HTTP 404 error if not found
	 */
	@PutMapping("/update")
	@Caching(evict = { 
			  @CacheEvict(value="all_authors", key="1"), 
			  @CacheEvict(value="author", key="#author.id") })
	public ResponseEntity<Author> update(@Valid @RequestBody Author author) {
		log.debug("REST call - updating author: {}", author);

		// use the service to do the work
		Author result = authorService.update(author);

		// create the response depending on the result
		if (result != null) {
			return new ResponseEntity<>(result, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * Creates an HTTP DELETE mapping on "/author/delete", that deletes an author for a given id.<br/>
	 * The ID is passed as request param, so it would look like "/author/delete?id=3"
	 * 
	 * @param id
	 *            the id of the author to be deleted
	 * @return HTTP 200 if successful, or HTTP 404 error if not found
	 */
	@DeleteMapping("/delete")
	@Caching(evict = { 
			  @CacheEvict(value="all_authors", key="1"), 
			  @CacheEvict(value="author", key="#id") })
	public ResponseEntity<String> delete(@RequestParam("id") long id) {
		log.debug("REST call - deleting author with id {}", id);

		// use the service to do the work, respond depending on the result
		if (authorService.delete(id)) {
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
