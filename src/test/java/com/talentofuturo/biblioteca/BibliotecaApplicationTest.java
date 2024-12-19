package com.talentofuturo.biblioteca;

import org.junit.jupiter.api.Test;
import io.swagger.v3.oas.models.OpenAPI;

import static org.junit.jupiter.api.Assertions.*;

class BibliotecaApplicationTest {

    @Test
    void testCustomOpenAPI() {
        // Arrange: Crear una instancia de la clase principal
        BibliotecaApplication application = new BibliotecaApplication();

        // Act: Llamar a la función customOpenAPI()
        OpenAPI openAPI = application.customOpenAPI();

        // Assert: Verificar que el objeto no es nulo
        assertNotNull(openAPI, "customOpenAPI() debe retornar un objeto OpenAPI");

        // Assert: Verificar las propiedades del objeto OpenAPI
        assertEquals("Biblioteca", openAPI.getInfo().getTitle(), "El título debe ser 'Biblioteca'");
        assertEquals("1.0.0", openAPI.getInfo().getVersion(), "La versión debe ser '1.0.0'");
        assertEquals("Almacen de libros", openAPI.getInfo().getDescription(), "La descripción debe ser 'Almacen de libros'");
    }
}