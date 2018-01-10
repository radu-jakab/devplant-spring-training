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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

	@ManyToOne
	private Library library;
}
