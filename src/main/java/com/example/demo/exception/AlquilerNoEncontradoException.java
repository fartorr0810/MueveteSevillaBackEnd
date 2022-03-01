package com.example.demo.exception;

public class AlquilerNoEncontradoException extends RuntimeException {
	public AlquilerNoEncontradoException() {
		super("Alquiler no encontrado");
	}
}
