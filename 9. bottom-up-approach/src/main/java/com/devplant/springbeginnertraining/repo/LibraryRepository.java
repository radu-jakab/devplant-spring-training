package com.devplant.springbeginnertraining.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devplant.springbeginnertraining.model.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long> {

}
