package com.example.demo.exception;
/**
 * Clase con la excepcion del Login.
 * @author fartorr0810
 *
 */
public class LoginErrorException extends RuntimeException{
	/**
	 * Constructor de la excepcion
	 */
	public LoginErrorException() {
		super("Email o Password incorrecto");
	}
}
