package edu.fiuba.algo3.modelo.Exclusividades.Estados;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface EstadoExclusividad {
    void aplicarExclusividadAlPuntaje(ExclusividadCompuesta unaExclusividad, Puntaje puntajeJugador);
}
