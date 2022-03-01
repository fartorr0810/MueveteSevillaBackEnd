package com.example.demo.exception;

public class ModeloVacioException extends RuntimeException{
	public ModeloVacioException() {
		super("El modelo no puede estar vacio");
	}
}
