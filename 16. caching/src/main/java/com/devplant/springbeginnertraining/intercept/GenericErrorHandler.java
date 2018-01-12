package com.devplant.springbeginnertraining.intercept;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.devplant.springbeginnertraining.dto.ErrorMessageDTO;
import com.devplant.springbeginnertraining.exceptions.LibraryException;
import com.devplant.springbeginnertraining.service.MessagesService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GenericErrorHandler {
	@Autowired
	private MessagesService messages;

	@ExceptionHandler(LibraryException.class)
	@ResponseStatus(value = HttpStatus.I_AM_A_TEAPOT)
	public @ResponseBody ErrorMessageDTO userFacingError(final LibraryException e) {
		log.debug("IllegalArgumentException intercepted, " + e.getMessage());

		ErrorMessageDTO response = ErrorMessageDTO.builder()
												.code(e.getErrorCode())
												.developerMessage(e.getDeveloperMessage())
												.localizedMessage(e.getMessage())
												.build();

		return response;
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public @ResponseBody ErrorMessageDTO invalidRESTRequest(MethodArgumentNotValidException e) {
		List<ObjectError> errors = e.getBindingResult().getAllErrors();
		StringBuilder result = new StringBuilder();
		ErrorMessageDTO response = new ErrorMessageDTO("", "", "");

		// append all errors in a message
		for (ObjectError err : errors) {
			try {
				result.append(messages.getMessage(err.getCodes()[0]));
			} catch (NoSuchMessageException ex) {
				// log any missing codes on console and the developer message
				log.error("missing code: " + err.getCodes()[0]);
				String currentDevMsg = response.getDeveloperMessage();
				response.setDeveloperMessage(currentDevMsg + ", missing code: " + err.getCodes()[0]);
			}
			result.append('\n');
		}
		if (result.length() != 0)
			result.deleteCharAt(result.length() - 1); // remove last endline

		return ErrorMessageDTO.builder()
				.localizedMessage(result.toString())
				.build();
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody ErrorMessageDTO generalException(Exception e) {
		ErrorMessageDTO response = new ErrorMessageDTO();
		response.setLocalizedMessage(messages.getMessage("general.server.error"));
		return response;
	}
}
