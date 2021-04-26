package it.edu.isspitagora.indovinaunnumero;

import it.edu.isspitagora.model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static PrimaryController controller;
  
    public void start(Stage stage) throws IOException {
        
        Model model = new Model();
        
         scene = new Scene(loadFXML("eserczio1"));
        
         controller.setModel(model);
        
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        Parent risultato;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        risultato = fxmlLoader.load();
        controller =fxmlLoader.getController();
        return risultato;
    }

    public static void main(String[] args) {
        launch();
    }

}