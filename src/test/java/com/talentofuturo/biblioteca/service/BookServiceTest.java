package com.talentofuturo.biblioteca.service;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import com.talentofuturo.biblioteca.model.Book;
import com.talentofuturo.biblioteca.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class BookServiceTest {

    @InjectMocks
    private BookService bookService; // La clase que estamos probando

    @Mock
    private BookRepository bookRepository; // Mock del repositorio

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }



    @Test
    void addNewBook() {

        // Arrange
        BookDTO bookDTO = new BookDTO("Title", "Description", 2023,"Author");
        String expectedId = "0";

        // Act
        String actualId = bookService.addNewBook(bookDTO);

        // Assert
        verify(bookRepository, times(1)).addBook(any(Book.class)); // Verifica que se llame al repositorio
        assertEquals(expectedId, actualId, "El ID del libro debería ser '0'");
    }

    @Test
    void getBook() {

        // Arrange
        String bookId = "0";
        Book book = new Book(bookId, new BookDTO("Title", "Description", 2023,"Author"));
        when(bookRepository.getBook(bookId)).thenReturn(book);

        // Act
        String bookDetails = bookService.getBook(bookId);

        // Assert
        verify(bookRepository, times(1)).getBook(bookId); // Verifica que se llame al repositorio
        assertEquals(book.toString(), bookDetails, "La información del libro debería coincidir con toString()");
    }

    @Test
    void getBooks() {

        // Arrange
        Book book1 = new Book("0", new BookDTO("Title", "Description", 2023,"Author"));
        Book book2 = new Book("1", new BookDTO("Title2", "Description2", 2022,"Author2"));
        List<Book> books = Arrays.asList(book1, book2);
        when(bookRepository.getBooks()).thenReturn(books);

        // Act
        String allBooks = bookService.getBooks();

        // Assert
        verify(bookRepository, times(1)).getBooks(); // Verifica que se llame al repositorio
        String expected = String.join("\n", book1.toString(), book2.toString());
        assertEquals(expected, allBooks, "La información de todos los libros debería estar concatenada");
    }
}
