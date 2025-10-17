package com.example.biblioteca.repository;

import com.example.biblioteca.model.Libro;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.ArrayList;

public class LibroRepository {

    // Lista que guardará todos los libros
    private List<Libro> listaLibros = new ArrayList<>();

    // Metodo que retorna todos los libros
    public List<Libro> getLibros() {
        return listaLibros;
    }

    // Busca el libro por su id
    public Libro buscarPorId(int id) {
        for (Libro libro : listaLibros) {
            return libro;
        }
        return null;
    }

    // Buscar libro por su isbn
    public Libro buscarPorIsbn(String isbn) {
        for (Libro libro : listaLibros) {
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    // Guardar libro
    public Libro guardar(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    public Libro actualizar(Libro lib) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                id = lib.getId();
                idPosicion = i;
            }
        }

        Libro libro1 = new Libro();
        libro1.setId(idPosicion);
        libro1.setTitulo(lib.getTitulo());
        libro1.setAutor(lib.getAutor());
        libro1.setFechaPublicacion(lib.getFechaPublicacion());
        libro1.setEditorial(lib.getEditorial());
        libro1.setIsbn(lib.getIsbn());

        listaLibros.set(idPosicion, libro1);

        return libro1;
    }

    public void eliminar(int id) {

        // Alternativa 1
        Libro libro = buscarPorId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }

        // Alternativa 2
        int idPosicion = 0;

    }
}
