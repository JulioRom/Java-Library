package com.talentofuturo.biblioteca.repositories;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.talentofuturo.biblioteca.exceptions.BookNotFoundException;
import com.talentofuturo.biblioteca.model.Book;

@Repository
public class BookRepositorySQL implements BookRepository {

	/**
	 * Almacén en memoria para los libros, simulando una base de datos.
	 */
	private static final Map<String, Book> books = new HashMap<>();

	/**
	 * Obtiene un libro por su ID.
	 *
	 * @param id El identificador del libro.
	 * @return El libro correspondiente al ID proporcionado.
	 * @throws BookNotFoundException Si el libro no se encuentra en el repositorio.
	 */
	@Override
	public Book getBook(String id) {
		Book book = books.getOrDefault(id, null);
		
		if (null == book) {
			throw new BookNotFoundException("BOOK_NOT_FOUND");
		}
		
		return book;
	}

	/**
	 * Agrega un nuevo libro al repositorio.
	 *
	 * @param bookToAdd El libro a agregar.
	 */
	@Override
	public void addBook(Book bookToAdd) {
		books.put(bookToAdd.getId(), bookToAdd);
	}

	/**
	 * Obtiene una lista de todos los libros disponibles en el repositorio.
	 *
	 * @return Una lista de objetos {@link Book}.
	 */
	@Override
	public List<Book> getBooks() {
		return new ArrayList<>(books.values());
	}

	/**
	 * Elimina un libro del repositorio por su ID.
	 *
	 * @param id El identificador del libro a eliminar.
	 */
	@Override
	public void removeBook(String id) {
		books.remove(id);
	}

	/**
	 * Actualiza un libro del repositorio por su ID y un nuevo libro.
	 *
	 * @param updatedBook El identificador del libro a actualizar.
	 */
	@Override
	public void updateBook(Book updatedBook) {
		books.put(updatedBook.getId(), updatedBook); // Reemplaza el libro en el mapa (HashMap)
	}

}
