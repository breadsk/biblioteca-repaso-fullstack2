package com.example.biblioteca.controller;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.service.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/libros")
public class LibroControllerV2 {

    private final LibroService libroService;

    public LibroControllerV2(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public List<Libro> getBooks() {
        return libroService.getBooks();
    }

    @GetMapping("/{id}")
    public Libro getBookById(@PathVariable int id) {
        return libroService.getLibroById(id);
    }

    @PostMapping
    public Libro saveBook(@RequestBody Libro libro) {
        return libroService.saveBook(libro);
    }

    @PutMapping("/{id}")
    public Libro updateBookById(@PathVariable int id, @RequestBody Libro libro) {
        return libroService.updateLibro(libro);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable int id) {
        return libroService.deleteLibro(id);
    }
}
