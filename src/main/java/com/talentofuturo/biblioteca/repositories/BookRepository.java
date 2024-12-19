package com.talentofuturo.biblioteca.repositories;

import java.util.List;

import com.talentofuturo.biblioteca.model.Book;

/**
 * Interfaz para gestionar las operaciones de repositorio relacionadas con los libros.
 */
public interface BookRepository {
	/**
	 * Obtiene un libro por su ID.
	 *
	 * @param id El identificador del libro.
	 * @return El libro correspondiente al ID proporcionado.
	 */
	Book getBook(String id);

	/**
	 * Agrega un nuevo libro al repositorio.
	 *
	 * @param bookToAdd El libro a agregar.
	 */
	void addBook(Book bookToAdd);

	/**
	 * Obtiene una lista de todos los libros disponibles en el repositorio.
	 *
	 * @return Una lista de objetos {@link Book}.
	 */
	List<Book> getBooks();

	/**
	 * Elimina un libro del repositorio por su ID.
	 *
	 * @param id El identificador del libro a eliminar.
	 */
	void removeBook(String id);

	/**
	 * Actualiza un libro del repositorio por su ID.
	 *
	 * @param updatedBook El identificador del libro a actualizar.
	 */
	void updateBook(Book updatedBook);
}
