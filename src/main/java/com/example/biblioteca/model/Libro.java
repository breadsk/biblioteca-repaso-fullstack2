package com.example.biblioteca.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Representa un libro en el inventario del ecommerce")
public class Libro {

    @Schema(description = "Identificador único del libro", example = "1", required = true)
    private int id;

    @Schema(description = "Código ISBN del libro (formato estándar de 13 dígitos)", example = "978-3-16-148410-0", required = true)
    private String isbn;

    @Schema(description = "Título del libro", example = "El Quijote", required = true)
    private String titulo;

    @Schema(description = "Editorial que publicó el libro", example = "Anaya")
    private String editorial;

    @Schema(description = "Año de publicación del libro", example = "1605", minimum = "1000", maximum = "2026")
    private int fechaPublicacion;

    @Schema(description = "Nombre completo del autor", example = "Miguel de Cervantes", required = true)
    private String autor;
}
