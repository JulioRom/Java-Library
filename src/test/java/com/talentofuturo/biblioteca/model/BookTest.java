package com.talentofuturo.biblioteca.model;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void testBookConstructor() {
        // Arrange
        String id = "1";
        BookDTO bookDTO = new BookDTO("Title", "Description", 2023,"Author");

        // Act
        Book book = new Book(id, bookDTO);

        // Assert
        assertEquals(id, book.getId(), "El ID debería coincidir con el proporcionado");
        assertEquals("Title", book.getTitle(), "El título debería coincidir con el proporcionado por BookDTO");
        assertEquals("Author", book.getAuthor(), "El autor debería coincidir con el proporcionado por BookDTO");
        assertEquals("Description", book.getDescription(), "La descripción debería coincidir con el proporcionado por BookDTO");
        assertEquals(2023, book.getYear(), "El año debería coincidir con el proporcionado por BookDTO");
    }

    @Test
    void testToStringMethod() {
        // Arrange
        String id = "1";
        BookDTO bookDTO = new BookDTO("Title", "Description", 2023,"Author");
        Book book = new Book(id, bookDTO);

        // Act
        String toStringResult = book.toString();

        // Assert
        assertTrue(toStringResult.contains("Title"), "El método toString debería incluir el título");
        assertTrue(toStringResult.contains("Author"), "El método toString debería incluir el autor");
        assertTrue(toStringResult.contains("Description"), "El método toString debería incluir la descripción");
        assertTrue(toStringResult.contains("2023"), "El método toString debería incluir el año");
    }
}