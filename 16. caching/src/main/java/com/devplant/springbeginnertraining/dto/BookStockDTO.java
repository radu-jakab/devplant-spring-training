package com.devplant.springbeginnertraining.dto;

import lombok.Data;

@Data
public class BookStockDTO {
	private long bookId;

	private String title;

	private String shortDescription;

	private String authorName;

	private Integer stock;
}
