module it.edu.isspitagora.progetto1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.edu.isspitagora.progetto1 to javafx.fxml;
    exports it.edu.isspitagora.indovinaunnumero;
}
