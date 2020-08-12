package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Mi primera ventana");


        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida();

        Scene escenaBienvenidos = new Scene(contenedorBienvenida, 1920, 1080);

        stage.setScene(escenaBienvenidos);
        stage.setFullScreen(false);

        stage.show();
    }
}
