package com.example.demo.exception;
/**
 * Clase con la excepcion del patinete no disponible
 * @author fartorr0810
 *
 */
public class PatineteNoDisponibleException extends RuntimeException {
	/**
	 * Constructor de la excepcion con el mensaje personalizado.s
	 */
	public PatineteNoDisponibleException() {
		super("El patinete ya esta alquilado");
	}
}
