package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

public class ExclusividadDeEmpate implements Exclusividad {
    @Override
    public Exclusividad componerExclusividad(Exclusividad unaExclusividad) {
        return null;
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadSimple unaExclusividad) {
        return null;
    }

    @Override
    public Exclusividad componerExclusividad(ExclusividadDoble unaExclusividad) {
        return null;
    }

    @Override
    public Exclusividad validarExclusividad(EstadoExclusividad unEstadoExclusividad) {
        return null;
    }
    @Override
    public void aplicarExclusividad(Puntaje puntajeJugador) {
        puntajeJugador.aplicarExclusividad(this);
    }
}
