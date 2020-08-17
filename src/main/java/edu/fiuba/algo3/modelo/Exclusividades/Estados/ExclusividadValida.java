package edu.fiuba.algo3.modelo.Exclusividades.Estados;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadValida implements EstadoExclusividad {
    @Override
    public void aplicarExclusividadAlPuntaje(ExclusividadCompuesta unaExclusividad, Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(unaExclusividad);
    }
}
