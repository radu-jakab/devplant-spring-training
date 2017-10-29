package com.devplant.springbeginnertraining.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// spring
@Entity
@Table(name = "AUTHOR")
public class Author {

	// marks this as part of the primary key
	@Id
	// tells jpa driver to choose appropriate generator strategy
	@GeneratedValue
	private long id;

	// sample column configuration
	@Column(name = "author_name", length = 128, unique = true)
	private String name;

	private String bio;

	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
	private List<Book> books;
}
