package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCompuestaCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCompuesta;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCompuestaDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCompuestaSimple;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadValida implements EstadoExclusividad {
    @Override
    public void aplicarExclusividadAlPuntaje(ExclusividadCompuesta unaExclusividad, Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(unaExclusividad);
    }
}
