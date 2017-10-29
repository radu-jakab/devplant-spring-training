package com.devplant.springbeginnertraining.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Author {

	private long id;

	private String name;

	private String bio;

	private List<Book> books;
}
