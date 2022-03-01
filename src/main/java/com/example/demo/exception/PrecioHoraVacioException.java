package com.example.demo.exception;

public class PrecioHoraVacioException extends RuntimeException{
	public PrecioHoraVacioException() {
		super("El precio hora del patiente no puede estar vacio, ser 0 o negativo");
	}
}
