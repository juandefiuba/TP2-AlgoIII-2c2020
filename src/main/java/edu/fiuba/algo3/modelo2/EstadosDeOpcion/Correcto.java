package edu.fiuba.algo3.modelo2.EstadosDeOpcion;

import edu.fiuba.algo3.modelo2.Jugador;

import java.util.LinkedList;

public class Correcto implements EstadoOpcion{

    @Override
    public void asignarEstadoDeRespuestaAJugadores(LinkedList<Jugador> jugadores) {
        jugadores.forEach(jugador -> jugador.estadoRespondioCorrecto());
    }
}
