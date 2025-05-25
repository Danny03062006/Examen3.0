package co.edu.poli.examen3.modelo;

/**
 * Clase que representa una Revista, que es un tipo específico de Materia.
 * Extiende la clase base Materia e incluye la frecuencia de publicación.
 */
public class Revista extends Materia {

    // Frecuencia con la que se publica la revista (por ejemplo: mensual, semanal, etc.)
    private String frecuenciaPublicacion;

    /**
     * Constructor que inicializa todos los campos de la revista, incluyendo los heredados.
     * 
     * @param codigo Código único de la revista.
     * @param titulo Título de la revista.
     * @param fechaDePublicacion Fecha en que se publicó.
     * @param numeroPaginas Cantidad de páginas.
     * @param autor Autor asociado a la revista.
     * @param frecuenciaPublicacion Frecuencia con la que se publica (mensual, semanal, etc.).
     */
    public Revista(String codigo, String titulo, String fechaDePublicacion, int numeroPaginas, Autor autor, String frecuenciaPublicacion) {
        super(codigo, titulo, fechaDePublicacion, numeroPaginas, autor);
        this.frecuenciaPublicacion = frecuenciaPublicacion;
    }

    /** @return Frecuencia de publicación de la revista. */
    public String getFrecuenciaPublicacion() {
        return frecuenciaPublicacion;
    }

    /** @param frecuenciaPublicacion Nueva frecuencia de publicación. */
    public void setFrecuenciaPublicacion(String frecuenciaPublicacion) {
        this.frecuenciaPublicacion = frecuenciaPublicacion;
    }

    /**
     * Devuelve una representación en texto con los datos de la revista,
     * incluyendo los datos heredados de Materia y la frecuencia de publicación.
     * 
     * @return Cadena con todos los datos de la revista.
     */
    @Override
    public String toString() {
        return super.toString() + "\nFrecuencia de Publicación: " + frecuenciaPublicacion;
    }
}
