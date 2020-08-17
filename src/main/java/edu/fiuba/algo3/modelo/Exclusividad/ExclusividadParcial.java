package edu.fiuba.algo3.modelo.Exclusividad;

public interface ExclusividadParcial {
    ExclusividadCompuesta componerExclusividad(ExclusividadParcial unaExclusividad);
    ExclusividadCompuesta componerExclusividad(ExclusividadParcialSimple unaExclusividad);
    ExclusividadCompuesta componerExclusividad(ExclusividadParcialDoble unaExclusividad);
}
