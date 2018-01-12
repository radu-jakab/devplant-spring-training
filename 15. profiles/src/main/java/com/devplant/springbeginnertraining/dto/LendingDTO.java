package com.devplant.springbeginnertraining.dto;

import java.time.LocalDate;
import java.time.ZonedDateTime;

import com.devplant.springbeginnertraining.model.Book;
import com.devplant.springbeginnertraining.model.Library;

import lombok.Data;

@Data
public class LendingDTO {
	private long id;

	private Book book;

	private ZonedDateTime lendingTime;

	private LocalDate dueReturnDate;

	private String clientName;

	private Library library;
}
