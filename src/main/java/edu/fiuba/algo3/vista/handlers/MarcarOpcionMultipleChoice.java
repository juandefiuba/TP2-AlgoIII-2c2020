package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador._AgregarRespuestaIndividualHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MarcarOpcionMultipleChoice implements EventHandler<ActionEvent> {

    private final Button boton;
    private final Kahoot kahoot;
    private final Opcion opcion;

    public MarcarOpcionMultipleChoice(Kahoot kahoot, Opcion opcion, Button boton){
        this.boton = boton;
        this.kahoot = kahoot;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        new _AgregarRespuestaIndividualHandler(kahoot, opcion).handle(actionEvent);
        boton.setStyle("-fx-font-size: 2.9em; -fx-border-width: 7px; -fx-border-color: #4ac228");
        //boton.setOnAction(); DESMARCAR OPCION ELEGIDA
    }
}
