package com.devplant.springbeginnertraining.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDTO {
	private String code;
	private String localizedMessage;
	private String developerMessage;
}
