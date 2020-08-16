package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface EstadoExclusividad {
    void aplicarExclusividadAlPuntaje(ExclusividadCompuesta unaExclusividad, Puntaje puntajeJugador);
}
