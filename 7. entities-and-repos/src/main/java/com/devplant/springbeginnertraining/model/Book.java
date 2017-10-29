package com.devplant.springbeginnertraining.model;

import javax.persistence.Entity;

import lombok.Builder;
import lombok.Data;

//lombok
@Data
@Builder
// Spring data
@Entity
public class Book {

	private long id;

	private String title;

	private String shortDescription;

	private Author author;
}
