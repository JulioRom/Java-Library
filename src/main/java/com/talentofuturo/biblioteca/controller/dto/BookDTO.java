package com.talentofuturo.biblioteca.controller.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * DTO (Data Transfer Object) para representar los datos de un libro.
 */
@AllArgsConstructor
@Getter
@Schema(description = "Objeto para transferir datos de un libro")
public class BookDTO {

	/**
	 * Título del libro.
	 */
	@Schema(description = "Título del libro", example = "El Principito")
	private String title;

	/**
	 * Descripción del libro.
	 */
	@Schema(description = "Descripción del libro", example = "Un clásico de la literatura infantil")
	private String description;

	/**
	 * Año de publicación del libro.
	 */
	@Schema(description = "Año de publicación", example = "1943")
	private int year;

	/**
	 * Autor del libro.
	 */
	@Schema(description = "Autor del libro", example = "Antoine de Saint-Exupéry")
	private String author;
}

