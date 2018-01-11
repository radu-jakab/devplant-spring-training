package com.devplant.springbeginnertraining.exceptions;

public class LibraryException extends RuntimeException {
	private static final long serialVersionUID = 8916121486944116634L;

	private String developerMessage;
	private String errorCode;

	public LibraryException(String message) {
		super(message);
	}

	public LibraryException(String message, String developerMessage) {
		this(message);
		this.developerMessage = developerMessage;
	}

	public LibraryException(String message, String developerMessage, String errorCode) {
		this(message);
		this.developerMessage = developerMessage;
		this.errorCode = errorCode;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}
}
