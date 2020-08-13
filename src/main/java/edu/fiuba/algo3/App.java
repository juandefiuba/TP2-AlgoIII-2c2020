package edu.fiuba.algo3;

import edu.fiuba.algo3.vista.ContenedorBienvenida;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class App extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        int altoDeVentana = 1000;
        int anchoDeVentana = 1500;
        stage.setMaxWidth(anchoDeVentana);
        stage.setMinWidth(anchoDeVentana);
        stage.setMinHeight(altoDeVentana);
        stage.setMaxHeight(altoDeVentana);
        stage.setTitle("Kahoot!");

        //////////////////////////// MÚSICA próximamente//////////////////////////////



        //AplicacionOnKeyPressEventHandler AplicacionOnKeyPressEventHandler = new AplicacionOnKeyPressEventHandler(stage, contenedorPrincipal.getBarraDeMenu());
        //escenaJuego.setOnKeyPressed(AplicacionOnKeyPressEventHandler);

        ContenedorBienvenida contenedorBienvenida = new ContenedorBienvenida(stage);
        Scene escenaBienvenida = new Scene(contenedorBienvenida, anchoDeVentana, altoDeVentana);

        stage.setScene(escenaBienvenida);

        stage.show();
    }
}
