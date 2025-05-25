package co.edu.poli.examen3.controlador;

import co.edu.poli.examen3.modelo.Autor;
import co.edu.poli.examen3.modelo.Materia;
import co.edu.poli.examen3.servicios.ImplementacionOperacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Controlador para el formulario CRUD de Materias.
 * Maneja eventos de la interfaz y se comunica con la lógica de negocio.
 */
public class FormularioController {

    // Instancia del servicio que realiza las operaciones CRUD sobre Materias
    private ImplementacionOperacion operacion = new ImplementacionOperacion();

    // Nombre del archivo para la serialización de objetos Materia
    private static final String ARCHIVO = "materias.ser";

    // Elementos de la interfaz FXML (campos de entrada y área de resultados)
    @FXML private TextField txtCodigo;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtFecha;
    @FXML private TextField txtPaginas;
    @FXML private TextField txtNombreAutor;
    @FXML private TextField txtNacionalidadAutor;
    @FXML private TextArea  txtAreaResultado;

    /**
     * Evento asociado al botón para crear una nueva materia.
     * Lee los datos desde la interfaz, crea un objeto Materia y lo guarda.
     */
    @FXML
    void crearMateria(ActionEvent event) {
        try {
            // Crear objeto Autor
            Autor autor = new Autor(txtNombreAutor.getText(), txtNacionalidadAutor.getText());
            // Crear objeto Materia con los datos ingresados
            Materia m = new Materia(
                txtCodigo.getText(),
                txtTitulo.getText(),
                txtFecha.getText(),
                Integer.parseInt(txtPaginas.getText()),
                autor
            );
            // Guardar la materia en la lista
            operacion.crear(m);
            txtAreaResultado.setText("Materia creada correctamente.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            // Manejo de error si el campo de páginas no es un número
            txtAreaResultado.setText("Error: páginas no es un número válido.");
        }
    }

    /**
     * Evento asociado al botón para leer una materia específica por código.
     */
    @FXML
    void leerMateria(ActionEvent event) {
        // Buscar la materia por código
        Materia m = operacion.leer(txtCodigo.getText());
        if (m != null) {
            // Mostrar la información y cargar los datos en los campos
            txtAreaResultado.setText(m.toString());
            cargarCampos(m);
        } else {
            txtAreaResultado.setText("Materia no encontrada.");
        }
    }

    /**
     * Evento para leer y mostrar todas las materias registradas.
     */
    @FXML
    void leerTodosMaterias(ActionEvent event) {
        // Obtener todas las materias
        Materia[] todas = operacion.leerTodos();
        if (todas.length == 0) {
            txtAreaResultado.setText("No hay materias registradas.");
        } else {
            // Concatenar todas las materias en un solo texto
            StringBuilder sb = new StringBuilder();
            for (Materia mat : todas) {
                sb.append(mat).append("\n\n");
            }
            txtAreaResultado.setText(sb.toString());
        }
    }

    /**
     * Evento para actualizar una materia existente.
     * Sobrescribe la información con los nuevos datos ingresados.
     */
    @FXML
    void actualizarMateria(ActionEvent event) {
        try {
            // Crear nuevo objeto Autor
            Autor autor = new Autor(txtNombreAutor.getText(), txtNacionalidadAutor.getText());
            // Crear nuevo objeto Materia
            Materia m = new Materia(
                txtCodigo.getText(),
                txtTitulo.getText(),
                txtFecha.getText(),
                Integer.parseInt(txtPaginas.getText()),
                autor
            );
            // Actualizar en la lista
            operacion.actualizar(m);
            txtAreaResultado.setText("Materia actualizada.");
            limpiarCampos();
        } catch (NumberFormatException e) {
            // Error si páginas no es un número
            txtAreaResultado.setText("Error: páginas no es un número válido.");
        }
    }

    /**
     * Evento para eliminar una materia por su código.
     */
    @FXML
    void eliminarMateria(ActionEvent event) {
        // Eliminar la materia de la lista
        operacion.eliminar(txtCodigo.getText());
        txtAreaResultado.setText("Materia eliminada (si existía).");
        limpiarCampos();
    }

    /**
     * Serializa (guarda en archivo) todas las materias registradas.
     */
    @FXML
    void serializarMaterias(ActionEvent event) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oos.writeObject(operacion.leerTodos());
            txtAreaResultado.setText("Materias serializadas en " + ARCHIVO);
        } catch (Exception e) {
            txtAreaResultado.setText("Error al serializar: " + e.getMessage());
        }
    }

    /**
     * Deserializa (carga desde archivo) las materias y las carga en memoria.
     */
    @FXML
    void deserializarMaterias(ActionEvent event) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            Materia[] des = (Materia[]) ois.readObject();
            // Crear nueva instancia del servicio e insertar materias deserializadas
            operacion = new ImplementacionOperacion();
            for (Materia m : des) operacion.crear(m);
            txtAreaResultado.setText("Materias cargadas desde " + ARCHIVO);
        } catch (Exception e) {
            txtAreaResultado.setText("Error al deserializar: " + e.getMessage());
        }
    }

    /**
     * Rellena los campos de texto del formulario con la información de una Materia.
     * @param m Materia a mostrar en el formulario
     */
    private void cargarCampos(Materia m) {
        txtCodigo.setText(m.getCodigo());                   // Código de la materia
        txtTitulo.setText(m.getTitulo());                   // Título de la materia
        txtFecha.setText(m.getFechaDePublicacion());        // Fecha de publicación
        txtPaginas.setText(String.valueOf(m.getNumeroPaginas())); // Número de páginas
        txtNombreAutor.setText(m.getAutor().getNombre());   // Nombre del autor
        txtNacionalidadAutor.setText(m.getAutor().getNacionalidad()); // Nacionalidad
    }

    /**
     * Limpia todos los campos del formulario.
     */
    private void limpiarCampos() {
        txtCodigo.clear();
        txtTitulo.clear();
        txtFecha.clear();
        txtPaginas.clear();
        txtNombreAutor.clear();
        txtNacionalidadAutor.clear();
    }
}
