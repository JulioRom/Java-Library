package com.talentofuturo.biblioteca.model;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * Clase que representa un libro en el sistema.
 */
@Getter
@ToString
public class Book {

	/**
	 * Identificador único del libro.
	 */
	private final String id;

	/**
	 * Título del libro.
	 */
	private final String title;

	/**
	 * Descripción del libro.
	 */
	private final String description;

	/**
	 * Año de publicación del libro.
	 */
	private final int year;

	/**
	 * Autor del libro.
	 */
	private final String author;

	/**
	 * Constructor de la clase Book.
	 *
	 * @param id El identificador único del libro.
	 * @param bookDTO Objeto {@link BookDTO} que contiene la información del libro.
	 */
	public Book(String id, BookDTO bookDTO) {
		this.id = id;
		this.title = bookDTO.getTitle();
		this.description = bookDTO.getDescription();
		this.year = bookDTO.getYear();
		this.author = bookDTO.getAuthor();
	}
}
