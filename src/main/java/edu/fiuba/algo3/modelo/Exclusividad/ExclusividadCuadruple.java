package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public class ExclusividadCuadruple implements Exclusividad {
    @Override
    public Exclusividad componerExclusividad(Exclusividad unaExclusividad) {
        return this;
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadSimple unaExclusividad) {
        return this;
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadDoble unaExclusividad) {
        return this;
    }

    @Override
    public Exclusividad validarExclusividad(EstadoExclusividad unEstadoExclusividad) {
        return unEstadoExclusividad.validarExclusividad(this);
    }

    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
