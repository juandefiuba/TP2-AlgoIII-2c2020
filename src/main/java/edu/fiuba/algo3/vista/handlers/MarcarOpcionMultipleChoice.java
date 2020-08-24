package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class MarcarOpcionMultipleChoice implements EventHandler<ActionEvent> {

    private final Button boton;
    private final Kahoot kahoot;
    private final Opcion opcion;
    private final Button botonOk;

    public MarcarOpcionMultipleChoice(Kahoot kahoot, Opcion opcion, Button boton, Button botonOk){
        this.boton = boton;
        this.kahoot = kahoot;
        this.opcion = opcion;
        this.botonOk = botonOk;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        botonOk.requestFocus();
        boton.setStyle("-fx-font-size: 2.9em; -fx-border-width: 7px; -fx-border-color: #4ac228");
    }
}
