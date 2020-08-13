package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadInvalida;
import edu.fiuba.algo3.modelo.Exclusividad.Estados.ExclusividadValida;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class ExclusividadSimple implements Exclusividad {
    @Override
    public Exclusividad componerExclusividad(Exclusividad unaExclusividad) {
        return unaExclusividad.componerExclusividad(this);
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadSimple unaExclusividad) {
        return new ExclusividadSimple();
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadDoble unaExclusividad) {
        return new ExclusividadDoble();
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
