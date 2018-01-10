package com.devplant.springbeginnertraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devplant.springbeginnertraining.model.Author;

// not really required, but good practice
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
