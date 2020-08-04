package edu.fiuba.algo3.modelo2.EstadosDeOpcion;

import edu.fiuba.algo3.modelo2.Jugador;

import java.util.LinkedList;

public class Incorrecto implements EstadoOpcion {

    @Override
    public void asignarEstadoDeRespuestaAJugadores(LinkedList<Jugador> jugadores) {
        jugadores.forEach(jugador -> jugador.estadoRespondioMal());
    }

    @Override
    public void asignarEstadoDeRespuestaAJugadoresQueNoMeEligieron(LinkedList<Jugador> jugadores) {
        jugadores.forEach(jugador -> jugador.estadoRespondioBien());
    }
}
