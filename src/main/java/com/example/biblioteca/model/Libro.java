package com.example.biblioteca.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    /**
     * @Data
     *       La anotación @Data es una combinación de varias anotaciones de Lombok.
     *       Genera automáticamente los siguientes métodos para la clase:
     *       1. @Getter: Genera métodos getter para todos los campos.
     *       2. @Setter: Genera métodos setter para todos los campos.
     *       3. @ToString: Genera un método toString que incluye todos los campos.
     *       4. @EqualsAndHashCode: Genera métodos equals y hashCode que comparan
     *       los campos.
     *       5. @RequiredArgsConstructor: Genera un constructor con los campos
     *       finales (final) y los campos marcados con @NonNull.
     */
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;
}
