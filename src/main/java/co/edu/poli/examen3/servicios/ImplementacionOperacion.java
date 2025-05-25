package co.edu.poli.examen3.servicios;

import co.edu.poli.examen3.modelo.Materia;
import java.io.*;
import java.util.ArrayList;

/**
 * Clase que implementa la interfaz Operacion para realizar operaciones CRUD
 * sobre una lista de objetos Materia, incluyendo serialización y deserialización.
 */
public class ImplementacionOperacion implements Operacion {

    // Lista que contiene todas las instancias de Materia (Libros, Revistas, etc.)
    private ArrayList<Materia> listaMaterias = new ArrayList<>();

    /**
     * Agrega un nuevo objeto Materia a la lista.
     * @param m Objeto Materia a agregar.
     */
    @Override
    public void crear(Materia m) {
        listaMaterias.add(m);
    }

    /**
     * Busca un objeto Materia por su código.
     * @param c Código de la materia.
     * @return La materia encontrada o null si no existe.
     */
    @Override
    public Materia leer(String c) {
        return listaMaterias.stream()
                            .filter(m -> m.getCodigo().equalsIgnoreCase(c))
                            .findFirst().orElse(null);
    }

    /**
     * Retorna todas las materias almacenadas en forma de arreglo.
     * @return Arreglo de Materias.
     */
    @Override
    public Materia[] leerTodos() {
        return listaMaterias.toArray(new Materia[0]);
    }

    /**
     * Actualiza los datos de una materia existente en la lista.
     * @param m Objeto Materia con los datos actualizados.
     */
    @Override
    public void actualizar(Materia m) {
        for (int i = 0; i < listaMaterias.size(); i++) {
            if (listaMaterias.get(i).getCodigo().equalsIgnoreCase(m.getCodigo())) {
                listaMaterias.set(i, m);
                return;
            }
        }
    }

    /**
     * Elimina una materia de la lista usando su código.
     * @param c Código de la materia a eliminar.
     */
    @Override
    public void eliminar(String c) {
        listaMaterias.removeIf(m -> m.getCodigo().equalsIgnoreCase(c));
    }

    /**
     * Serializa la lista de materias en un archivo.
     * @param file Nombre del archivo donde se guardará la lista.
     */
    @Override
    public void serializar(String file) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(file))) {
            o.writeObject(listaMaterias);
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error si ocurre durante la escritura
        }
    }

    /**
     * Deserializa el contenido de un archivo a la lista de materias.
     * @param file Nombre del archivo desde el cual se recuperará la lista.
     * @return Arreglo de Materias deserializadas.
     */
    @Override
    public Materia[] deserializar(String file) {
        try (ObjectInputStream i = new ObjectInputStream(new FileInputStream(file))) {
            listaMaterias = (ArrayList<Materia>) i.readObject();
        } catch (Exception e) {
            e.printStackTrace(); // Imprime el error si ocurre durante la lectura
        }
        return listaMaterias.toArray(new Materia[0]);
    }
}
