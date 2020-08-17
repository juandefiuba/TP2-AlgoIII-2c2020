package edu.fiuba.algo3.modelo.Exclusividad;

public class ExclusividadParcialDoble implements ExclusividadParcial {

    @Override
    public ExclusividadCompuesta componerExclusividad(ExclusividadParcial unaExclusividad) {
        return unaExclusividad.componerExclusividad(this);
    }

    @Override
    public ExclusividadCompuesta componerExclusividad(ExclusividadParcialSimple unaExclusividad) {
        return new ExclusividadCompuestaDoble();
    }

    @Override
    public ExclusividadCompuesta componerExclusividad(ExclusividadParcialDoble unaExclusividad) {
        return new ExclusividadCompuestaCuadruple();
    }
}
