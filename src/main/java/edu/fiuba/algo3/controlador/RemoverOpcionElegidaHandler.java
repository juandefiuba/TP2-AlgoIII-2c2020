package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoverOpcionElegidaHandler implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;
    private final Opcion opcion;

    public RemoverOpcionElegidaHandler(Kahoot kahoot, Opcion opcion) {
        this.kahoot = kahoot;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.removerOpcionElegida(opcion);
    }
}