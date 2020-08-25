package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.RemoverOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class DesmarcarOpcionMultipleChoice implements EventHandler<ActionEvent> {

    private final Button boton;
    private final Kahoot kahoot;
    private final Opcion opcion;
    private final Button botonOk;

    public DesmarcarOpcionMultipleChoice(Kahoot kahoot, Opcion opcion, Button boton, Button botonOk){
        this.boton = boton;
        this.kahoot = kahoot;
        this.opcion = opcion;
        this.botonOk = botonOk;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        new RemoverOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        botonOk.requestFocus();
        boton.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        boton.setOnAction(new MarcarOpcionMultipleChoice(kahoot, opcion, boton, botonOk));
    }
}
