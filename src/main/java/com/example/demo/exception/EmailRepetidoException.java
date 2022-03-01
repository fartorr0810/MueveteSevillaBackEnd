package com.example.demo.exception;
/**
 * Clase con la excepcion del email.
 * @author fartorr0810
 *
 */
public class EmailRepetidoException extends RuntimeException{
	/**
	 * Constructor de la excepcion
	 * @param email
	 */
	public EmailRepetidoException(String email) {
		super("El correo esta repetido : "+email);
	}
}
