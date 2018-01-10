package com.devplant.springbeginnertraining.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//lombok
@Data
@Builder
@NoArgsConstructor
@ToString(exclude = "author")
// spring
@Entity
@Table(name = "BOOK")
public class Book {

	// marks this as part of the primary key
	@Id
	// tells jpa driver to choose appropriate generator strategy
	@GeneratedValue
	private long id;

	private String title;

	private String shortDescription;

	@JsonBackReference("authorBooks")
	@ManyToOne
	private Author author;

	private Book(long id, String title, String shortDescription, Author author) {
		super();
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.author = author;
	}
}
