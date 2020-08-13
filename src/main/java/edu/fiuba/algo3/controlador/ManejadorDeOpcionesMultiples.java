package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import java.util.LinkedList;

import edu.fiuba.algo3.modelo.Opcion.Opcion;

public class ManejadorDeOpcionesMultiples implements EventHandler<ActionEvent> {
    private LinkedList<Opcion> respuesta;
    private Opcion opcion;
    private Button opcionActual;

    public ManejadorDeOpcionesMultiples(LinkedList<Opcion> respuesta, Opcion opcion, Button opcionActual) {
        this.respuesta = respuesta;
        this.opcion = opcion;
        this.opcionActual = opcionActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.respuesta.add(this.opcion);
        this.opcionActual.setDisable(true);
    }
}