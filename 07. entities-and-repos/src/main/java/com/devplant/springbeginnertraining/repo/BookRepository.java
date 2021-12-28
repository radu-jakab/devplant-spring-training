package com.devplant.springbeginnertraining.repo;

import com.devplant.springbeginnertraining.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// not really required, but good practice
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
