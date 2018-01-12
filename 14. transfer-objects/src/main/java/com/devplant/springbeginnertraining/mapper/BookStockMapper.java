package com.devplant.springbeginnertraining.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.devplant.springbeginnertraining.dto.BookStockDTO;
import com.devplant.springbeginnertraining.model.Book;

@Mapper(componentModel = "spring")
public interface BookStockMapper {

	@Mappings({
		@Mapping(source = "book.id", target = "bookId"),
		@Mapping(source = "book.title", target = "title"),
		@Mapping(source = "book.shortDescription", target = "shortDescription"),
		@Mapping(source = "book.author.name", target = "authorName"),
		@Mapping(source = "stock", target = "stock")
	})
	BookStockDTO getAsBookStock(Book book, Integer stock);
}
