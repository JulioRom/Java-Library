package com.talentofuturo.biblioteca.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.talentofuturo.biblioteca.controller.dto.BookDTO;
import com.talentofuturo.biblioteca.exceptions.BookNotFoundException;
import com.talentofuturo.biblioteca.service.BookService;

/**
 * Controlador REST para gestionar las operaciones relacionadas con los libros.
 * Proporciona endpoints para obtener y crear libros.
 */
@Slf4j
@Tag(name = "Books", description = "API para la gestión de libros")
@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    /**
     * Servicio para gestionar la lógica de negocio relacionada con los libros.
     */
    @Autowired
    private BookService service;

    /**
     * Obtiene la información de un libro específico a partir de su ID.
     *
     * @param id El identificador del libro.
     * @return Una respuesta HTTP que contiene la información del libro si se encuentra,
     * o un mensaje de error si el libro no existe.
     */
    @Operation(summary = "Obtener información de un libro", description = "Devuelve los detalles de un libro por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Detalles del libro devueltos exitosamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<String> getBook(@Parameter(description = "El identificador único del libro", example = "1", required = true) @PathVariable String id) {
        try {
            String bookInfo = service.getBook(id);
            return new ResponseEntity<>(bookInfo, HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Obtiene la lista de todos los libros disponibles.
     *
     * @return Una cadena con la información de todos los libros.
     */
    @Operation(summary = "Obtener lista de libros", description = "Devuelve todos los libros disponibles en el sistema")
    @ApiResponse(responseCode = "200", description = "Lista de libros devuelta exitosamente")
    @GetMapping("/")
    public String getBooks() {
        return service.getBooks();
    }


    /**
     * Crea un nuevo libro a partir de los datos proporcionados.
     *
     * @param body Un objeto {@link BookDTO} que contiene los datos del libro a crear.
     * @return El ID del nuevo libro creado.
     */
    @Operation(summary = "Crear un nuevo libro", description = "Agrega un nuevo libro al sistema con los detalles proporcionados")
    @ApiResponse(responseCode = "201", description = "Libro creado exitosamente")
    @PostMapping("/")
    public String createBook(@RequestBody BookDTO body) {
        String newId = service.addNewBook(body);
        log.info("Nuevo libro con ID: {}", newId);
        return newId;
    }

    /**
     * Elimina un libro del sistema a partir de su ID.
     *
     * @param id El identificador del libro.
     * @return Una respuesta HTTP que indica si la operación fue exitosa o si el libro no fue encontrado.
     */
    @Operation(summary = "Eliminar un libro", description = "Elimina un libro existente del sistema por su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro eliminado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@Parameter(description = "El identificador único del libro", example = "1", required = true) @PathVariable String id) {
        try {
            service.removeBook(id);
            return new ResponseEntity<>("Book deleted successfully", HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Actualiza los detalles de un libro existente.
     *
     * @param id El identificador del libro a actualizar.
     * @param body Un objeto {@link BookDTO} con los nuevos detalles del libro.
     * @return Una respuesta HTTP que indica si la operación fue exitosa o si el libro no fue encontrado.
     */
    @Operation(summary = "Actualizar un libro", description = "Actualiza los detalles de un libro existente en el sistema")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Libro actualizado exitosamente"),
            @ApiResponse(responseCode = "404", description = "Libro no encontrado")
    })
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(
            @Parameter(description = "El identificador único del libro", example = "1", required = true) @PathVariable String id,
            @RequestBody BookDTO body) {
        try {
            service.updateBook(id, body);
            return new ResponseEntity<>("Book updated successfully", HttpStatus.OK);
        } catch (BookNotFoundException e) {
            return new ResponseEntity<>("RESOURCE_NOT_FOUND", HttpStatus.NOT_FOUND);
        }
    }
}
