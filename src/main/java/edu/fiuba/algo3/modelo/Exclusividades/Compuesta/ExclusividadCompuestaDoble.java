package edu.fiuba.algo3.modelo.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadCompuestaDoble extends ExclusividadCompuestaBase {
    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
