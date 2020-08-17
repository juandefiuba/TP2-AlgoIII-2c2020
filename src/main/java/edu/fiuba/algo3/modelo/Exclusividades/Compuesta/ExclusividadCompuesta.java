package edu.fiuba.algo3.modelo.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface ExclusividadCompuesta {
    void aplicarExclusividad(Puntaje puntajeJugador);

    void aplicarExclusividadAPuntajes(Puntaje puntajeJugador, Puntaje puntajeJugador2);
}
