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
        //jugadores.forEach(jugador -> jugador.estadoRespondioBien()); no es necesario decir que
        //responden bien los que no elijen una opcion con estado Incorrecto, ya que si la elijen
        //Es una "Muerte Subita"
    }
}
