package co.edu.poli.examen3.servicios;

import co.edu.poli.examen3.modelo.Materia;

/**
 * Interfaz que define las operaciones básicas para gestionar objetos de tipo Materia.
 * Incluye métodos CRUD, serialización y deserialización.
 */
public interface Operacion {

    /**
     * Crea y agrega una nueva Materia.
     * @param materia La materia a agregar.
     */
    void crear(Materia materia);

    /**
     * Busca una Materia por su código.
     * @param codigo Código único de la materia.
     * @return La materia encontrada o null si no existe.
     */
    Materia leer(String codigo);

    /**
     * Retorna todas las materias existentes.
     * @return Un arreglo con todas las materias.
     */
    Materia[] leerTodos();

    /**
     * Actualiza la información de una Materia existente.
     * @param materia La materia con la información actualizada.
     */
    void actualizar(Materia materia);

    /**
     * Elimina una Materia de acuerdo con su código.
     * @param codigo Código de la materia a eliminar.
     */
    void eliminar(String codigo);

    /**
     * Serializa y guarda la lista de materias en un archivo.
     * @param nombreArchivo Nombre del archivo de destino.
     */
    void serializar(String nombreArchivo);

    /**
     * Carga y deserializa la lista de materias desde un archivo.
     * @param nombreArchivo Nombre del archivo fuente.
     * @return Arreglo de materias cargadas.
     */
    Materia[] deserializar(String nombreArchivo);
}
