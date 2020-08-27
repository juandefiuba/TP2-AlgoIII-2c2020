package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Opciones.OpcionIncorrecta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AgregarOpcionElegidaHandler implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;
    private final Opcion opcion;

    public AgregarOpcionElegidaHandler(Kahoot kahoot, Opcion opcion) {
        this.kahoot = kahoot;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarOpcionElegida(opcion);
    }
}