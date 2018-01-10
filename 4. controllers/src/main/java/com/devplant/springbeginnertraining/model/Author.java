package com.devplant.springbeginnertraining.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@Builder
@NoArgsConstructor
public class Author {

	private long id;

	private String name;

	private String bio;

	// avoid circular reference at JSON serialization
	@JsonManagedReference("authorBooks")
	private List<Book> books;

	private Author(long id, String name, String bio, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.bio = bio;
		this.books = books;
	}
}
