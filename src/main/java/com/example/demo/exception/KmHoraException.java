package com.example.demo.exception;

public class KmHoraException extends RuntimeException{
	public KmHoraException() {
		super("No puede ser negativo o 0");
	}
}
