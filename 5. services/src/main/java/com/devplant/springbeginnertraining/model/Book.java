package com.devplant.springbeginnertraining.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

	private long id;

	private String title;

	private String shortDescription;

	// avoid circular reference at JSON serialization
	@JsonIgnore
	private Author author;
}
