package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public interface Estado {

    EstadoDeRespuesta esCorrecta(Estado valor);

    EstadoDeRespuesta esCorrecta(Correcto valor);

    EstadoDeRespuesta esCorrecta(Incorrecto valor);
}
