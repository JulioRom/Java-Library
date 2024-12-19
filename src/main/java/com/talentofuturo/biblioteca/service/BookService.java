package com.talentofuturo.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import com.talentofuturo.biblioteca.model.Book;
import com.talentofuturo.biblioteca.repositories.BookRepository;

@Service
public class BookService {


	/**
	 * Contador estático para la cantidad de libros disponibles.
	 */
	private static int bookQuantity = 0;

	/**
	 * Repositorio para gestionar la persistencia de los libros.
	 */
	@Autowired
	private BookRepository bookRepository;

	/**
	 * Agrega un nuevo libro al repositorio.
	 *
	 * @param bookDTO Objeto {@link BookDTO} con los datos del libro a agregar.
	 * @return El ID del libro recién agregado.
	 */
	public String addNewBook(BookDTO bookDTO) {
		String currentId = String.valueOf(bookQuantity);
		Book bookToAdd = new Book(currentId, bookDTO);
		
		bookRepository.addBook(bookToAdd);
		
		bookQuantity++;
		
		return currentId;
	}

	/**
	 * Obtiene la información de un libro específico a partir de su ID.
	 *
	 * @param id El identificador del libro.
	 * @return Una cadena que representa los detalles del libro.
	 */
	public String getBook(String id) {
		Book book = bookRepository.getBook(id);
		return book.toString();
	}

	/**
	 * Obtiene la información de todos los libros disponibles en el repositorio.
	 *
	 * @return Una cadena con los detalles de todos los libros.
	 */
	public String getBooks() {
		StringBuilder strBuilder = new StringBuilder();
		
		for (Book book : bookRepository.getBooks()) {
			strBuilder.append(book.toString());
			strBuilder.append("\n");
		}
		
		return strBuilder.toString();
	}

	public void removeBook(String id) {
		// Intentamos obtener el libro para verificar si existe.
		Book book = bookRepository.getBook(id);

		// Si no se lanza excepción, eliminamos el libro.
		bookRepository.removeBook(id);
		System.out.println(book.toString());

	}

	public void updateBook(String id, BookDTO bookDTO) {
		// Verificar si el libro existe, de lo contrario lanzar excepción
		Book existingBook = bookRepository.getBook(id); // Lanza BookNotFoundException si no existe

		// Crear un nuevo objeto Book con los datos actualizados
		Book updatedBook = new Book(id, bookDTO);

		// Actualizar el libro en el repositorio
		bookRepository.updateBook(updatedBook); // Método para reemplazar el libro en el repositorio
	}
}
