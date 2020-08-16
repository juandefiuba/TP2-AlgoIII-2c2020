package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;

public class ExclusividadValida implements EstadoExclusividad {
    @Override
    public Exclusividad validarExclusividad(ExclusividadSimple exclusividadSimple) {
        return new ExclusividadSimple();
    }

    @Override
    public Exclusividad validarExclusividad(ExclusividadDoble exclusividadSimple) {
        return new ExclusividadDoble();
    }

    @Override
    public Exclusividad validarExclusividad(ExclusividadCuadruple exclusividadSimple) {
        return new ExclusividadCuadruple();
    }
}
