package com.devplant.springbeginnertraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devplant.springbeginnertraining.model.Book;

// not really required, but good practice
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
