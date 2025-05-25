module co.edu.poli.examen3 {
    requires javafx.controls;
    requires javafx.fxml;

    opens co.edu.poli.examen3 to javafx.fxml, javafx.graphics;
    opens co.edu.poli.examen3.vista to javafx.fxml, javafx.graphics;
}
