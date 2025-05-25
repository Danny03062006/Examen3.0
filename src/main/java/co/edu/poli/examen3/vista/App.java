package co.edu.poli.examen3.vista;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase principal que inicia la aplicación JavaFX.
 * Carga la interfaz gráfica desde el archivo FXML y la muestra en una ventana.
 */
public class App extends Application {

    /**
     * Método llamado automáticamente al iniciar la aplicación JavaFX.
     * Se encarga de cargar el archivo FXML y configurar la escena principal.
     *
     * @param stage Ventana principal (stage) de la aplicación.
     * @throws Exception si ocurre algún error al cargar el archivo FXML.
     */
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(
          getClass().getResource("/co/edu/poli/examen3/vista/formulario.fxml")
        );
        stage.setScene(new Scene(root));
        stage.setTitle("Examen 3 - JavaFX CRUD");
        stage.show();
    }

    /**
     * Método main que lanza la aplicación JavaFX.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch();
    }
}
