package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.LinkedList;

import edu.fiuba.algo3.modelo.Opciones.Opcion;

public class AgregarOpcionElegidaHandler implements EventHandler<ActionEvent> {
    private Kahoot kahoot;
    private Opcion opcion;

    public AgregarOpcionElegidaHandler(Kahoot kahoot, Opcion opcion) {
        this.kahoot = kahoot;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarOpcionElegida(opcion);
    }
}