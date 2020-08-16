package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.*;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadInvalida implements EstadoExclusividad {
    @Override
    public void aplicarExclusividadAlPuntaje(ExclusividadCompuesta unaExclusividad, Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
