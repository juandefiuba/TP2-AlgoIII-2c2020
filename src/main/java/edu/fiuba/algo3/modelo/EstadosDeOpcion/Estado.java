package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public abstract class Estado {

    public abstract EstadoDeRespuesta esCorrecta(Estado valor);

    public abstract EstadoDeRespuesta esCorrecta(Verdadero valor);
    public abstract EstadoDeRespuesta esCorrecta(Falso valor);
}
