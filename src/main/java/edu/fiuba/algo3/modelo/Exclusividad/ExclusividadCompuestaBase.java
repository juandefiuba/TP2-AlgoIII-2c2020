package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public abstract class ExclusividadCompuestaBase implements ExclusividadCompuesta {
    public void aplicarExclusividadAPuntajes(Puntaje puntajeJugador, Puntaje puntajeJugador2) {
        EstadoExclusividad estadoExclusividad = puntajeJugador.emparejarPuntaje(puntajeJugador2);
        estadoExclusividad.aplicarExclusividadAlPuntaje(this, puntajeJugador);
        estadoExclusividad.aplicarExclusividadAlPuntaje(this, puntajeJugador2);
    }
}
