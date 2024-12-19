package com.talentofuturo.biblioteca.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookDTOTest {


    @Test
    void testBookDTOConstructorAndGetters() {
        // Arrange
        String title = "El Principito";
        String description = "Un clásico de la literatura infantil";
        int year = 1943;
        String author = "Antoine de Saint-Exupéry";

        // Act
        BookDTO bookDTO = new BookDTO(title, description, year, author);

        // Assert
        assertEquals(title, bookDTO.getTitle(), "El título debería coincidir con el proporcionado");
        assertEquals(description, bookDTO.getDescription(), "La descripción debería coincidir con el proporcionado");
        assertEquals(year, bookDTO.getYear(), "El año debería coincidir con el proporcionado");
        assertEquals(author, bookDTO.getAuthor(), "El autor debería coincidir con el proporcionado");
    }

}