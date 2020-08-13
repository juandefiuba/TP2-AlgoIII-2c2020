package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.*;

public class ExclusividadInvalida implements EstadoExclusividad {
    @Override
    public Exclusividad validarExclusividad(ExclusividadSimple exclusividadSimple) {
        return new ExclusividadSimple();
    }

    @Override
    public Exclusividad validarExclusividad(ExclusividadDoble exclusividadSimple) {
        return new ExclusividadDeEmpate();
    }

    @Override
    public Exclusividad validarExclusividad(ExclisividadCuadruple exclusividadSimple) {
        return new ExclusividadDeEmpate();
    }
}
