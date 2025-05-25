package co.edu.poli.examen3.modelo;

import java.io.Serializable;

/**
 * Clase que representa un autor con nombre y nacionalidad.
 * Implementa Serializable para permitir la persistencia del objeto.
 */
public class Autor implements Serializable {

    private String nombre;           // Nombre del autor
    private String nacionalidad;     // Nacionalidad del autor

    /**
     * Constructor para crear un autor con nombre y nacionalidad.
     * @param nombre Nombre del autor.
     * @param nacionalidad Nacionalidad del autor.
     */
    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    /** @return el nombre del autor */
    public String getNombre() { return nombre; }

    /** @param nombre nuevo nombre para el autor */
    public void setNombre(String nombre) { this.nombre = nombre; }

    /** @return la nacionalidad del autor */
    public String getNacionalidad() { return nacionalidad; }

    /** @param nacionalidad nueva nacionalidad del autor */
    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    /**
     * Representación en texto del autor.
     * @return Cadena con el nombre y nacionalidad del autor.
     */
    @Override
    public String toString() {
        return nombre + " (" + nacionalidad + ")";
    }
}
