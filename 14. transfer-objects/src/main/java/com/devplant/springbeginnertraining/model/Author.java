package com.devplant.springbeginnertraining.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// lombok
@Data
@Builder
@NoArgsConstructor
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
	@Size(min = 2, max = 128, message = "Author name must have between 2 and 128 characters")
	private String name;

	@NotNull(message = "Author bio cannot be null")
	@NotEmpty(message = "Author bio cannot be empty")
	private String bio;

	@JsonManagedReference("authorBooks")
	@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
	private List<Book> books;

	private Author(long id, String name, String bio, List<Book> books) {
		super();
		this.id = id;
		this.name = name;
		this.bio = bio;
		this.books = books;
	}
}
