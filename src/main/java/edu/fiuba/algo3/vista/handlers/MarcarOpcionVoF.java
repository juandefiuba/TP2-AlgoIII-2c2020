package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;


public class MarcarOpcionVoF implements EventHandler<ActionEvent> {

    private final Opcion opcion;
    private final Kahoot kahoot;
    private final Button boton;

    public MarcarOpcionVoF(Opcion opcion, Kahoot kahoot, Button boton){
        this.opcion = opcion;
        this.kahoot = kahoot;
        this.boton = boton;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        boton.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #5ae334");
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
    }

}
