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
    public Libro searchById(int id) {
        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
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
    public Libro saveBook(Libro lib) {
        listaLibros.add(lib);
        return lib;
    }

    public Libro updateBook(Libro lib) {

        int idPosicion = -1; // Usar -1 para indicar "no encontrado"

        for (int i = 0; i < listaLibros.size(); i++) {
            if (listaLibros.get(i).getId() == lib.getId()) {
                idPosicion = i;
                break; // IMPORTANTE: salir cuando lo encuentres
            }
        }

        if (idPosicion == -1) {
            return null; // Libro no encontrado
        }

        // Actualizar el libro existente (NO rear uno nuevo)
        // ¿Por qué no necesitas listaLibros.set()?
        // Porque NO estás cambiando la referencia en la lista,
        // solo estás modificando el contenido del objeto al que apunta esa referencia.
        Libro libroExistente = listaLibros.get(idPosicion);
        libroExistente.setId(idPosicion);
        libroExistente.setTitulo(lib.getTitulo());
        libroExistente.setAutor(lib.getAutor());
        libroExistente.setFechaPublicacion(lib.getFechaPublicacion());
        libroExistente.setEditorial(lib.getEditorial());
        libroExistente.setIsbn(lib.getIsbn());

        return libroExistente;
    }

    public void eliminar(int id) {

        // Alternativa 1
        // Libro libro = buscarPorId(id);
        // if (libro != null) {
        // listaLibros.remove(libro);
        // }

        // Alternativa 2
        // int idPosicion = 0;
        // for (int i = 0; i < listaLibros.size(); i++) {
        // if (listaLibros.get(i).getId() == id) {
        // idPosicion = i;
        // break;
        // }
        // }

        // if (idPosicion > 0) {
        // listaLibros.remove(idPosicion);
        // }

        // otra alternativa
        listaLibros.removeIf(x -> x.getId() == id);

    }

}
