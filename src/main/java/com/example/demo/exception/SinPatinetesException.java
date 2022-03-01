package com.example.demo.exception;
/**
 * Clase con la excepcion de que no haya patinetes
 * @author fartorr0810
 *
 */
public class SinPatinetesException extends RuntimeException{
	/**
	 * Constructor de la excepcion
	 * @param email
	 */
	public SinPatinetesException() {
		super("No hay patinetes");

	}
}
