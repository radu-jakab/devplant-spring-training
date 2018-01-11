package com.devplant.springbeginnertraining.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.devplant.springbeginnertraining.model.Lending;
import com.devplant.springbeginnertraining.service.LendingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("lending")
@ResponseBody
//log4j capability added via lombok
@Slf4j
public class LendingController {

	@Autowired
	private LendingService lendingService;

	@GetMapping()
	public List<Lending> getAll() {
		log.debug("REST call - getting all lendings");
		return lendingService.getAllLendings();
	}

	@GetMapping("/forClient")
	public List<Lending> getLendedBooksForClient(@RequestParam String name) {
		log.debug("REST call - getting all lendings for client name={}", name);
		
		return lendingService.getAllLendingsForClient(name);
	}

}
