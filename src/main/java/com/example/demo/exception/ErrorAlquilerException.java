package com.example.demo.exception;

public class ErrorAlquilerException extends RuntimeException{
	public ErrorAlquilerException(){
		super("Faltan datos para completar el alquiler");
	}
}
