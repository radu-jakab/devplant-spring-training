package com.devplant.springbeginnertraining.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devplant.springbeginnertraining.dto.LendingDTO;
import com.devplant.springbeginnertraining.mapper.LendingMapper;
import com.devplant.springbeginnertraining.model.Lending;
import com.devplant.springbeginnertraining.repo.LendingRepository;

@Service
public class LendingService {

	@Autowired
	LendingMapper lendingMapper;

	@Autowired
	private LendingRepository lendingRepo;

	/**
	 * @return a list of all books lended by the library
	 */
	public List<Lending> getAllLendings() {
		return lendingRepo.findAll();
	}

	/**
	 * Returns the list of all books lended to a particular client
	 * 
	 * @param clientName
	 *            the client to retrieve lended books for
	 * @return the list of lended books
	 */
	public List<LendingDTO> getAllLendingsForClient(String clientName) {
		List<Lending> lendings = lendingRepo.findAllByClientName(clientName);

		return lendings.stream().map((lending) -> {
			return lendingMapper.lendingToLendingDTO(lending);
		}).collect(Collectors.toList());
	}

}
