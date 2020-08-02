package edu.fiuba.algo3.modelo2;

import java.util.LinkedList;

public class Incorrecto implements EstadoOpcion {

    @Override
    public void asignarPuntajeAJugadores(LinkedList<Jugador> jugadores) {
        jugadores.forEach(jugador -> jugador.sumarPuntos(0));
    }

}
