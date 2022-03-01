package com.example.demo.exception;

public class SinPermisoException extends RuntimeException{
	public SinPermisoException() {
		super("No tienes permiso");
	}
}
