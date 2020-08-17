package edu.fiuba.algo3.modelo.Exclusividades.Parcial;

import edu.fiuba.algo3.modelo.Exclusividades.Compuesta.ExclusividadCompuesta;

public interface ExclusividadParcial {
    ExclusividadCompuesta componerExclusividad(ExclusividadParcial unaExclusividad);
    ExclusividadCompuesta componerExclusividad(ExclusividadParcialSimple unaExclusividad);
    ExclusividadCompuesta componerExclusividad(ExclusividadParcialDoble unaExclusividad);
}
