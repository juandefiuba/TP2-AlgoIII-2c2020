package edu.fiuba.algo3.vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CambiarDeEscena implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final Scene escena;

    public CambiarDeEscena(Stage stage, Scene escena) {
        this.stage = stage;
        this.escena = escena;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setScene(escena);
    }

}
