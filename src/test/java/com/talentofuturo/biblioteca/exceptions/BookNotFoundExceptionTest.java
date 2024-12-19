package com.talentofuturo.biblioteca.exceptions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BookNotFoundExceptionTest {


    @Test
    void testBookNotFoundExceptionMessage() {
        // Arrange
        String errorMessage = "Book not found";

        // Act
        BookNotFoundException exception = new BookNotFoundException(errorMessage);

        // Assert
        assertEquals(errorMessage, exception.getMessage(), "El mensaje de la excepción debería coincidir con el proporcionado");
    }
}