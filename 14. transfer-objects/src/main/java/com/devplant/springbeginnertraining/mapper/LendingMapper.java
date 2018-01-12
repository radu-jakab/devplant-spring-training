package com.devplant.springbeginnertraining.mapper;

import org.mapstruct.Mapper;

import com.devplant.springbeginnertraining.dto.LendingDTO;
import com.devplant.springbeginnertraining.model.Lending;

@Mapper(componentModel = "spring")
public interface LendingMapper {
	LendingDTO lendingToLendingDTO(Lending lending);

	Lending lendingDTOtoLending(LendingDTO lendingDTO);
}
