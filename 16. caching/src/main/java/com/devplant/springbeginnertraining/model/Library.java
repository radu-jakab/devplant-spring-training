package com.devplant.springbeginnertraining.model;

import java.util.List;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//lombok
@Data
@Builder
@NoArgsConstructor
// spring
@Entity
@Table(name = "LIBRARY")
public class Library {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ElementCollection
	private Map<Book, Integer> stocks;

	@JsonManagedReference("libraryLendings")
	@OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
	private List<Lending> lendedBooks;

	public Library(long id, String name, Map<Book, Integer> stocks, List<Lending> lendedBooks) {
		super();
		this.id = id;
		this.name = name;
		this.stocks = stocks;
		this.lendedBooks = lendedBooks;
	}
}
