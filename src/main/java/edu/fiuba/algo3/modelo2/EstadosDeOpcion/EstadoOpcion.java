package edu.fiuba.algo3.modelo2.EstadosDeOpcion;

import edu.fiuba.algo3.modelo2.Jugador;

import java.util.LinkedList;

public interface EstadoOpcion {
     void asignarEstadoDeRespuestaAJugadores(LinkedList<Jugador> jugadores);
}
