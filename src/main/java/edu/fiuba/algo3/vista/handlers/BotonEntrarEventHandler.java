package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.ContenedorInicio;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public BotonEntrarEventHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorInicio contenedorInicio = new ContenedorInicio(stage);
        Scene escenaInicio = new Scene(contenedorInicio, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaInicio);

        //stage.setFullScreenExitHint("");
        //stage.setFullScreen(true);
    }

}