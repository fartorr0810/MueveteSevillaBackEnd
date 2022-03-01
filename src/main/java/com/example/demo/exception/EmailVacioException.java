package com.example.demo.exception;

public class EmailVacioException extends RuntimeException{
	
	public EmailVacioException() {
		super("El email no puede estar vacio");
	}
}
