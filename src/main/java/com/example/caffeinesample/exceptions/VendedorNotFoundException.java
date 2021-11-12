package com.example.caffeinesample.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class VendedorNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VendedorNotFoundException(String message) {
		super(message);
	}
	
	public VendedorNotFoundException(String message, Throwable causedBy) {
		super(message, causedBy);
	}
	
}