package com.devplant.springbeginnertraining.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@JsonIgnore
	@ManyToOne()
	private Author author;
}
