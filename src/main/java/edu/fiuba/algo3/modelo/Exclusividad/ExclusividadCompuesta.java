package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface ExclusividadCompuesta {
    void aplicarExclusividad(Puntaje puntajeJugador);

    void aplicarExclusividadAPuntajes(Puntaje puntajeJugador, Puntaje puntajeJugador2);
}
