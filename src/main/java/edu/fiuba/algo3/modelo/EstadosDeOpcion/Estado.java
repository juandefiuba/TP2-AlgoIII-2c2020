package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public abstract class Estado {

    public abstract EstadoDeRespuesta esCorrecta(Estado valor);

    public abstract EstadoDeRespuesta esCorrecta(Correcto valor);
    public abstract EstadoDeRespuesta esCorrecta(Incorrecto valor);
}
