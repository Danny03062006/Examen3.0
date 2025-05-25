package co.edu.poli.examen3.vista;

import co.edu.poli.examen3.modelo.Materia;
import co.edu.poli.examen3.servicios.ImplementacionOperacion;
import co.edu.poli.examen3.modelo.Autor;

import java.util.Scanner;

/**
 * Clase que maneja la interfaz de usuario mediante consola
 * y permite realizar operaciones CRUD sobre las materias,
 * además de serializar y deserializar la lista de materias.
 */
public class Principal {

    // Objeto para manejar las operaciones CRUD y la persistencia
    private static ImplementacionOperacion operacion = new ImplementacionOperacion();

    /**
     * Método principal que muestra un menú en consola
     * para que el usuario interactúe con las materias.
     * 
     * @param args argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n*** Menú CRUD ***");
            System.out.println("1. Crear materia");
            System.out.println("2. Leer materia");
            System.out.println("3. Leer todas las materias");
            System.out.println("4. Actualizar materia");
            System.out.println("5. Eliminar materia");
            System.out.println("6. Serializar materias");
            System.out.println("7. Deserializar materias");
            System.out.println("8. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearMateria(scanner);
                    break;
                case 2:
                    leerMateria(scanner);
                    break;
                case 3:
                    leerTodasLasMaterias();
                    break;
                case 4:
                    actualizarMateria(scanner);
                    break;
                case 5:
                    eliminarMateria(scanner);
                    break;
                case 6:
                    serializarMaterias(scanner);
                    break;
                case 7:
                    deserializarMaterias(scanner);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 8);

        scanner.close();
    }

    /**
     * Crea una nueva materia solicitando datos al usuario.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void crearMateria(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el código de la materia: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese el título de la materia: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese la fecha de publicación (dd/mm/yyyy): ");
        String fechaDePublicacion = scanner.nextLine();
        System.out.print("Ingrese el número de páginas: ");
        int numeroPaginas = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.print("Ingrese la nacionalidad del autor: ");
        String nacionalidadAutor = scanner.nextLine();

        Autor autor = new Autor(nombreAutor, nacionalidadAutor);
        Materia materia = new Materia(codigo, titulo, fechaDePublicacion, numeroPaginas, autor);

        operacion.crear(materia);
        System.out.println("Materia creada exitosamente.");
    }

    /**
     * Busca y muestra una materia por su código.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void leerMateria(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el código de la materia a buscar: ");
        String codigo = scanner.nextLine();

        Materia materia = operacion.leer(codigo);
        if (materia != null) {
            System.out.println("Materia encontrada:");
            System.out.println(materia);
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    /**
     * Muestra todas las materias almacenadas.
     */
    private static void leerTodasLasMaterias() {
        Materia[] materias = operacion.leerTodos();
        if (materias.length > 0) {
            System.out.println("Listado de todas las materias:");
            for (Materia materia : materias) {
                System.out.println(materia);
            }
        } else {
            System.out.println("No hay materias almacenadas.");
        }
    }

    /**
     * Actualiza los datos de una materia existente.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void actualizarMateria(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el código de la materia a actualizar: ");
        String codigo = scanner.nextLine();

        Materia materiaExistente = operacion.leer(codigo);
        if (materiaExistente != null) {
            System.out.print("Ingrese el nuevo título de la materia: ");
            String nuevoTitulo = scanner.nextLine();
            System.out.print("Ingrese la nueva fecha de publicación (dd/mm/yyyy): ");
            String nuevaFecha = scanner.nextLine();
            System.out.print("Ingrese el nuevo número de páginas: ");
            int nuevasPaginas = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer
            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nuevoNombreAutor = scanner.nextLine();
            System.out.print("Ingrese la nueva nacionalidad del autor: ");
            String nuevaNacionalidadAutor = scanner.nextLine();

            Autor nuevoAutor = new Autor(nuevoNombreAutor, nuevaNacionalidadAutor);
            Materia nuevaMateria = new Materia(codigo, nuevoTitulo, nuevaFecha, nuevasPaginas, nuevoAutor);

            operacion.actualizar(nuevaMateria);
            System.out.println("Materia actualizada exitosamente.");
        } else {
            System.out.println("Materia no encontrada.");
        }
    }

    /**
     * Elimina una materia por su código.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void eliminarMateria(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el código de la materia a eliminar: ");
        String codigo = scanner.nextLine();

        operacion.eliminar(codigo);
        System.out.println("Materia eliminada.");
    }

    /**
     * Serializa las materias a un archivo especificado.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void serializarMaterias(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre del archivo para serializar las materias: ");
        String nombreArchivo = scanner.nextLine();

        operacion.serializar(nombreArchivo);
        System.out.println("Materias serializadas exitosamente.");
    }

    /**
     * Deserializa las materias desde un archivo especificado.
     * 
     * @param scanner Scanner para entrada de datos
     */
    private static void deserializarMaterias(Scanner scanner) {
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Ingrese el nombre del archivo para deserializar las materias: ");
        String nombreArchivo = scanner.nextLine();

        operacion.deserializar(nombreArchivo);
        System.out.println("Materias deserializadas exitosamente.");
    }
}
