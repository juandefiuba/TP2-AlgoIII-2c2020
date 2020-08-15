package edu.fiuba.algo3.modelo.Exclusividad;

import edu.fiuba.algo3.modelo.Exclusividad.Estados.EstadoExclusividad;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;

public interface Exclusividad {
    Exclusividad componerExclusividad(Exclusividad unaExclusividad);
    Exclusividad componerExclusividad(ExclusividadSimple unaExclusividad);
    Exclusividad componerExclusividad(ExclusividadDoble unaExclusividad);

    Exclusividad validarExclusividad(EstadoExclusividad unEstadoExclusividad);

    void aplicarExclusividad(Puntaje puntajeJugador);
}
