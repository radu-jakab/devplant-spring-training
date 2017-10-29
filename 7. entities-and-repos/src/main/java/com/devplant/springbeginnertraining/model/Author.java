package com.devplant.springbeginnertraining.model;

import java.util.List;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;

// lombok
@Data
@Builder
// Spring data
@Entity
public class Author {

	private long id;

	private String name;

	private String bio;

	private List<Book> books;
}
