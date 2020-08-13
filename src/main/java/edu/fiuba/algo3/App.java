package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenida;
import edu.fiuba.algo3.vista.ContenedorInicio;
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
        int altoDeVentana = 1000;
        int anchoDeVentana = 1500;

        stage.setTitle("Kahoot!");

        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio, anchoDeVentana, altoDeVentana);

        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(escenaInicio, stage);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, anchoDeVentana, altoDeVentana);

        stage.setScene(escenaBienvenida);

        stage.show();
    }
}
