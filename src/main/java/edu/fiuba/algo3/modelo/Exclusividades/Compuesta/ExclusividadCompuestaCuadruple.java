package edu.fiuba.algo3.modelo.Exclusividades.Compuesta;

import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadCompuestaCuadruple extends ExclusividadCompuestaBase {
    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
