package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadCompuestaSimple extends ExclusividadCompuestaBase {
    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
    public void aplicarExclusividadAPuntajes(Puntaje puntajeJugador, Puntaje puntajeJugador2) {
    }
}
