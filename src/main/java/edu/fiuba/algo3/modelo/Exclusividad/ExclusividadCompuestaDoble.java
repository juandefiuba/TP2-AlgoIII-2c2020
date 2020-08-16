package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadCompuestaDoble extends ExclusividadCompuestaBase {
    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
