package com.devplant.springbeginnertraining.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devplant.springbeginnertraining.model.Lending;

@Repository
public interface LendingRepository extends JpaRepository<Lending, Long> {

	// BEWARE! UNICORN MAGIC AHEAD!
	// SpringData notation that gets transformed into JPQL query statement
	public List<Lending> findAllByClientName(String clientName);
}
