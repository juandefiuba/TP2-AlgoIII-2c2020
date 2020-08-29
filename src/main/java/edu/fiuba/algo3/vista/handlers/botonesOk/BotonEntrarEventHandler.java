package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.contenedores.ContenedorInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonEntrarEventHandler implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Kahoot kahoot;

    public BotonEntrarEventHandler(Stage stage, Kahoot kahoot) {
        this.stage = stage;
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        ContenedorInicio contenedorInicio = new ContenedorInicio(stage, kahoot);
        Scene escenaInicio = new Scene(contenedorInicio, stage.getWidth(), stage.getHeight());
        stage.setScene(escenaInicio);
    }

}