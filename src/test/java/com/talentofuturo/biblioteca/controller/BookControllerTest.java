package com.talentofuturo.biblioteca.controller;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import com.talentofuturo.biblioteca.exceptions.BookNotFoundException;
import com.talentofuturo.biblioteca.service.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

import static org.junit.jupiter.api.Assertions.*;

class BookControllerTest {

    @InjectMocks
    private BookController controller;

    @Mock
    private BookService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void testGetBook_Success() {
        // Arrange
        String bookId = "1";
        String bookInfo = "Book info";
        when(service.getBook(bookId)).thenReturn(bookInfo);

        // Act
        ResponseEntity<String> response = controller.getBook(bookId);

        // Assert
        assertEquals(OK, response.getStatusCode(), "El código de estado debería ser 200 OK");
        assertEquals(bookInfo, response.getBody(), "El cuerpo de la respuesta debería contener la información del libro");
        verify(service, times(1)).getBook(bookId); // Verifica que se llamó al servicio
    }

    @Test
    void testGetBook_NotFound() {
        // Arrange
        String bookId = "1";
        when(service.getBook(bookId)).thenThrow(new BookNotFoundException("BOOK_NOT_FOUND"));

        // Act
        ResponseEntity<String> response = controller.getBook(bookId);

        // Assert
        assertEquals(NOT_FOUND, response.getStatusCode(), "El código de estado debería ser 404 NOT_FOUND");
        assertEquals("RESOURCE_NOT_FOUND", response.getBody(), "El cuerpo de la respuesta debería contener 'RESOURCE_NOT_FOUND'");
        verify(service, times(1)).getBook(bookId); // Verifica que se llamó al servicio
    }

    @Test
    void testGetBooks() {
        // Arrange
        String booksInfo = "Book1\nBook2";
        when(service.getBooks()).thenReturn(booksInfo);

        // Act
        String response = controller.getBooks();

        // Assert
        assertEquals(booksInfo, response, "La respuesta debería contener la lista de libros");
        verify(service, times(1)).getBooks(); // Verifica que se llamó al servicio
    }

    @Test
    void testCreateBook() {
        // Arrange
        BookDTO bookDTO = new BookDTO("Title", "Description", 2023, "Author");
        String newBookId = "123";
        when(service.addNewBook(bookDTO)).thenReturn(newBookId);

        // Act
        String response = controller.createBook(bookDTO);

        // Assert
        assertEquals(newBookId, response, "La respuesta debería contener el ID del nuevo libro");
        verify(service, times(1)).addNewBook(bookDTO); // Verifica que se llamó al servicio
    }

}