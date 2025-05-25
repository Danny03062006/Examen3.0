package co.edu.poli.examen3.modelo;

/**
 * Clase que representa un libro, que es una especialización de una materia.
 * Hereda atributos de la clase Materia y añade el campo específico 'género'.
 */
public class Libro extends Materia {

    private String genero;  // Género literario del libro (ej: novela, poesía, ciencia ficción)

    /**
     * Constructor para crear un objeto de tipo Libro con todos sus atributos.
     * @param codigo Código único del libro.
     * @param titulo Título del libro.
     * @param fechaDePublicacion Fecha en que fue publicado el libro.
     * @param numeroPaginas Número total de páginas del libro.
     * @param autor Objeto Autor que representa al autor del libro.
     * @param genero Género literario del libro.
     */
    public Libro(String codigo, String titulo, String fechaDePublicacion, int numeroPaginas, Autor autor, String genero) {
        super(codigo, titulo, fechaDePublicacion, numeroPaginas, autor);
        this.genero = genero;
    }

    /**
     * Obtiene el género del libro.
     * @return El género literario del libro.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el género del libro.
     * @param genero Nuevo género a asignar al libro.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Devuelve una representación en texto del libro, incluyendo los datos de la clase padre y el género.
     * @return Cadena con los datos completos del libro.
     */
    @Override
    public String toString() {
        return super.toString() + "\nGénero: " + genero;
    }
}
