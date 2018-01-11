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

@RestController
@RequestMapping("lending")
@ResponseBody
public class LendingController {

	@Autowired
	private LendingService lendingService;

	@GetMapping()
	public List<Lending> getAll() {
		return lendingService.getAllLendings();
	}

	@GetMapping("/forClient")
	public List<Lending> getLendedBooksForClient(@RequestParam String name) {
		return lendingService.getAllLendingsForClient(name);
	}

}
