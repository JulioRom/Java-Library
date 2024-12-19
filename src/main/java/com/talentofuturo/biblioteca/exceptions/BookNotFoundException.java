package com.talentofuturo.biblioteca.exceptions;

/**
 * Excepción personalizada para manejar casos en los que un libro no es encontrado.
 */
public class BookNotFoundException extends RuntimeException {
	/**
	 * Constructor que crea una nueva instancia de BookNotFoundException.
	 *
	 * @param msg El mensaje de error asociado a la excepción.
	 */
	public BookNotFoundException(String msg) {
		super(msg);
	}
}
