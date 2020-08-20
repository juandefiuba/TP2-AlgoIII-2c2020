package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.ContenedorInicio;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    Stage stage;
    Kahoot kahoot;

    public BotonEntrarEventHandler(Stage stage, Kahoot kahoot) {
        this.stage = stage;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, kahoot);
        Scene escenaInicio = new Scene(contenedorInicio, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.sizeToScene();
        stage.setScene(escenaInicio);
    }

}