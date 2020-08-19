package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class NuevoJugadorHandler implements EventHandler<ActionEvent> {

    private Kahoot kahoot;
    private String nombreJugador;

    public NuevoJugadorHandler(Kahoot kahoot, String nombreJugador) {
        this.kahoot = kahoot;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.agregarJugador(nombreJugador);
    }
}
