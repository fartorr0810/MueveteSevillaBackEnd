package com.example.demo.exception;

public class PasswordVaciaException extends RuntimeException{
	public PasswordVaciaException() {
		super("El password no puede estar vacio");
	}
}
