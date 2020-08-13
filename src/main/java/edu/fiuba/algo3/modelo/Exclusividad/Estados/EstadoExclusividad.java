package edu.fiuba.algo3.modelo.Exclusividad.Estados;

import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadCuadruple;
import edu.fiuba.algo3.modelo.Exclusividad.Exclusividad;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadDoble;
import edu.fiuba.algo3.modelo.Exclusividad.ExclusividadSimple;

public interface EstadoExclusividad {
    Exclusividad validarExclusividad(ExclusividadSimple exclusividadSimple);
    Exclusividad validarExclusividad(ExclusividadDoble exclusividadSimple);
    Exclusividad validarExclusividad(ExclusividadCuadruple exclusividadSimple);
}
