package com.example.demo.exception;

public class ContenidoComentarioVacioException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContenidoComentarioVacioException() {
		super("Contenido del comentario vacio");
	}
}
