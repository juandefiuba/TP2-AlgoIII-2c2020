package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opcion;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorDeOpciones implements EventHandler<ActionEvent> {
    private Jugador jugador;
    private Opcion opcion;

    public ManejadorDeOpciones(Jugador jugador, Opcion opcion) {
        this.jugador = jugador;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        opcion.agregarJugadorQueLaEligio(jugador);
    }
}
