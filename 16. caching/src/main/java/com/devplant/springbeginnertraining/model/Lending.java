package com.devplant.springbeginnertraining.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//lombok
@Data
@Builder
@NoArgsConstructor
@ToString(exclude = "library")
// spring
@Entity
@Table(name = "LENDING")
public class Lending {

	@Id
	@GeneratedValue
	private long id;

	@OneToOne
	private Book book;

	@Past
	private ZonedDateTime lendingTime;

	@Future
	private LocalDate dueReturnDate;

	private String clientName;

	@JsonBackReference("libraryLendings")
	@ManyToOne
	private Library library;

	private Lending(long id, Book book, ZonedDateTime lendingTime, LocalDate dueReturnDate, String clientName, Library library) {
		super();
		this.id = id;
		this.book = book;
		this.lendingTime = lendingTime;
		this.dueReturnDate = dueReturnDate;
		this.clientName = clientName;
		this.library = library;
	}
}
