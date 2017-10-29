package com.devplant.springbeginnertraining.model;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name = "LENDING")
public class Lending {

	@Id
	@GeneratedValue
	private long id;

	private Book book;

	private ZonedDateTime lendingTime;

	private LocalDate dueReturnDate;

	private String clientName;

	@ManyToOne
	private Library library;
}
