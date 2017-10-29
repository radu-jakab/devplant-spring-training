package com.devplant.springbeginnertraining.model;

import java.util.List;
import java.util.Map;

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

//lombok
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
// spring
@Entity
@Table(name = "LIBRARY")
public class Library {

	@Id
	@GeneratedValue
	private long id;

	private Map<Book, Integer> stocks;

	@OneToMany(mappedBy = "library", fetch = FetchType.LAZY)
	private List<Lending> lendedBooks;
}
