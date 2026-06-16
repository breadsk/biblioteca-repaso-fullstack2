package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/libros")
@Tag(name = "Inventix", description = "Operaciones relacionadas con ecommerce")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos", description = "Obtiene una lista de todos los productos")
    public List<Libro> getBooks() {
        return libroService.getBooks();
    }

    @GetMapping("{id}")
    public Libro getBookById(@PathVariable int id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    public Libro saveBook(@RequestBody Libro libro) {
        return libroService.saveBook(libro);
    }

    @PutMapping("{id}")
    public Libro updateBookById(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping
    public String deleteBookById(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }

}
