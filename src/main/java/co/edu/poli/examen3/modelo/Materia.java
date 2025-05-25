package co.edu.poli.examen3.modelo;

import java.io.Serializable;

/**
 * Clase que representa una materia o publicación general.
 * Implementa la interfaz Serializable para permitir su serialización.
 */
public class Materia implements Serializable {

    private String codigo;                  // Código único de la materia
    private String titulo;                 // Título de la materia
    private String fechaDePublicacion;     // Fecha de publicación (formato libre)
    private int numeroPaginas;             // Número de páginas de la materia
    private Autor autor;                   // Autor asociado a la materia

    /**
     * Constructor para inicializar todos los atributos de la materia.
     * 
     * @param codigo Código único de la materia.
     * @param titulo Título de la materia.
     * @param fechaDePublicacion Fecha en la que fue publicada.
     * @param numeroPaginas Número total de páginas.
     * @param autor Objeto Autor que representa al autor de la materia.
     */
    public Materia(String codigo, String titulo, String fechaDePublicacion, int numeroPaginas, Autor autor) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.fechaDePublicacion = fechaDePublicacion;
        this.numeroPaginas = numeroPaginas;
        this.autor = autor;
    }

    // Getters y setters...

    /** @return El código de la materia. */
    public String getCodigo() { return codigo; }

    /** @param codigo Nuevo código para la materia. */
    public void setCodigo(String codigo) { this.codigo = codigo; }

    /** @return El título de la materia. */
    public String getTitulo() { return titulo; }

    /** @param titulo Nuevo título para la materia. */
    public void setTitulo(String titulo) { this.titulo = titulo; }

    /** @return Fecha de publicación. */
    public String getFechaDePublicacion() { return fechaDePublicacion; }

    /** @param f Nueva fecha de publicación. */
    public void setFechaDePublicacion(String f) { this.fechaDePublicacion = f; }

    /** @return Número de páginas de la materia. */
    public int getNumeroPaginas() { return numeroPaginas; }

    /** @param n Nuevo número de páginas. */
    public void setNumeroPaginas(int n) { this.numeroPaginas = n; }

    /** @return Autor de la materia. */
    public Autor getAutor() { return autor; }

    /** @param a Nuevo autor para la materia. */
    public void setAutor(Autor a) { this.autor = a; }

    /**
     * Devuelve una representación en texto con todos los datos de la materia.
     * @return Cadena con código, título, fecha, páginas y autor.
     */
    @Override
    public String toString() {
        return String.format(
          "Código: %s%nTítulo: %s%nFecha: %s%nPáginas: %d%nAutor: %s",
          codigo, titulo, fechaDePublicacion, numeroPaginas, autor
        );
    }
}
