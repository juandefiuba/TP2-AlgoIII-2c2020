package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorDeNombreJugador implements EventHandler<ActionEvent> {

    private Jugador jugador;
    private String nombreJugador;

    /* Quizás el modelo podría tener jugadores que se creen sin
    nombre para yo luego setearle el nombre con un método.*/
    public ManejadorDeNombreJugador(Jugador jugador, String nombreJugador) {
        this.jugador = jugador;
        this.nombreJugador = nombreJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        //jugador.nombrar(nombreJugador); //Este método debería ser implementado por el jugador en el modelo.
    }
}
