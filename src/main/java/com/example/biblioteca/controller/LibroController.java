package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
@Tag(name = "Inventix", description = "Operaciones relacionadas con el ecommerce de productos (libros)")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Obtiene una lista de todos los productos (libros) disponibles en el inventario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de productos obtenida exitosamente", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Libro.class)))),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    public List<Libro> getBooks() {
        return libroService.getBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Obtener un producto por ID", description = "Retorna un producto (libro) específico basado en su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto encontrado", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
            @ApiResponse(responseCode = "500", description = "Error interno del servidor", content = @Content)
    })
    public Libro getBookById(
            @Parameter(description = "ID del producto a buscar", example = "1", required = true) @PathVariable int id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    @Operation(summary = "Crear un nuevo producto", description = "Agrega un nuevo producto (libro) al inventario.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto creado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class))),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida (datos incorrectos)", content = @Content)
    })
    public Libro saveBook(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto Libro que se va a crear", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class), examples = @ExampleObject(name = "Ejemplo de libro", value = """
                    {
                        "id": 1,
                        "isbn": "978-3-16-148410-0",
                        "titulo": "El Quijote",
                        "editorial": "Anaya",
                        "fechaPublicacion": 1605,
                        "autor": "Miguel de Cervantes"
                    }
                    """))) @RequestBody Libro libro) {
        return libroService.saveBook(libro);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un producto existente", description = "Actualiza los datos de un producto (libro) existente por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto actualizado exitosamente", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content),
            @ApiResponse(responseCode = "400", description = "Solicitud inválida", content = @Content)
    })
    public Libro updateBookById(
            @Parameter(description = "ID del producto a actualizar", example = "1", required = true) @PathVariable int id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "Objeto Libro con los datos actualizados", required = true, content = @Content(mediaType = "application/json", schema = @Schema(implementation = Libro.class), examples = @ExampleObject(name = "Ejemplo de actualización", value = """
                    {
                        "id": 1,
                        "isbn": "978-3-16-148410-1",
                        "titulo": "El Quijote de la Mancha",
                        "editorial": "Alfaguara",
                        "fechaPublicacion": 1605,
                        "autor": "Miguel de Cervantes Saavedra"
                    }
                    """))) @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un producto", description = "Elimina un producto (libro) del inventario por su ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Producto eliminado exitosamente", content = @Content(mediaType = "text/plain", examples = @ExampleObject(value = "Producto eliminado"))),
            @ApiResponse(responseCode = "404", description = "Producto no encontrado", content = @Content)
    })
    public String deleteBookById(
            @Parameter(description = "ID del producto a eliminar", example = "1", required = true) @PathVariable int id) {
        return libroService.deleteLibro(id);
    }
}