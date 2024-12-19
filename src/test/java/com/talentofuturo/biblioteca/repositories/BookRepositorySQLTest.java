package com.talentofuturo.biblioteca.repositories;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import com.talentofuturo.biblioteca.exceptions.BookNotFoundException;
import com.talentofuturo.biblioteca.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


class BookRepositorySQLTest {

    private BookRepositorySQL bookRepository;

    @BeforeEach
    void setUp() {
        bookRepository = new BookRepositorySQL();
    }

    @Test
    void testAddBook() {
        // Arrange
        Book book = new Book("1", new BookDTO("Title", "Description", 2023,"Author"));

        // Act
        bookRepository.addBook(book);

        // Assert
        assertEquals(book, bookRepository.getBook("1"), "El libro debería haberse agregado correctamente");
    }


    @Test
    void testGetBook_ExistingBook() {
        // Arrange
        Book book = new Book("1", new BookDTO("Title", "Description", 2023,"Author"));
        bookRepository.addBook(book);

        // Act
        Book retrievedBook = bookRepository.getBook("1");

        // Assert
        assertEquals(book, retrievedBook, "El libro obtenido debería coincidir con el agregado");
    }

    @Test
    void testGetBook_NonExistingBook() {
        // Act & Assert
        Exception exception = assertThrows(BookNotFoundException.class, () -> bookRepository.getBook("999"));
        assertEquals("BOOK_NOT_FOUND", exception.getMessage(), "Debería lanzar una excepción con el mensaje 'BOOK_NOT_FOUND'");
    }

    @Test
    void testGetBooks() {
        // Arrange
        Book book1 = new Book("1", new BookDTO("Title", "Description", 2023,"Author"));
        Book book2 = new Book("2", new BookDTO("Title2", "Description2", 2022,"Author2"));
        bookRepository.addBook(book1);
        bookRepository.addBook(book2);

        // Act
        List<Book> books = bookRepository.getBooks();

        // Assert
        assertEquals(2, books.size(), "Debería haber 2 libros en el repositorio");
        assertTrue(books.contains(book1), "El repositorio debería contener el primer libro");
        assertTrue(books.contains(book2), "El repositorio debería contener el segundo libro");
    }

    @Test
    void testRemoveBook() {
        // Arrange
        Book book = new Book("1", new BookDTO("Title", "Description", 2023,"Author"));
        bookRepository.addBook(book);

        // Act
        bookRepository.removeBook("1");

        // Assert
        assertThrows(BookNotFoundException.class, () -> bookRepository.getBook("1"), "El libro debería haberse eliminado del repositorio");
    }
}