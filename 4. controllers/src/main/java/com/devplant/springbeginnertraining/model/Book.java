package com.devplant.springbeginnertraining.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

//lombok
@Data
@Builder
@ToString(exclude = "author")
public class Book {

	private long id;

	private String title;

	private String shortDescription;

	// avoid circular reference at JSON serialization
	@JsonBackReference("authorBooks")
	private Author author;

	private Book(long id, String title, String shortDescription, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.author = author;
	}
}
