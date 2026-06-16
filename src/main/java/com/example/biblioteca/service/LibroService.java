package com.example.biblioteca.service;

import com.example.biblioteca.model.Libro;
import com.example.biblioteca.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> getBooks() {
        return libroRepository.getBooks();
    }

    public Libro saveBook(Libro libro) {
        return libroRepository.saveBook(libro);
    }

    public Libro getLibroById(int id) {
        return libroRepository.searchById(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.updateBook(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "Producto eliminado";
    }
}
