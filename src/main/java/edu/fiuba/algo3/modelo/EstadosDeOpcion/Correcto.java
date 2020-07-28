package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

public class Correcto extends Estado {

    public EstadoDeRespuesta esCorrecta(Correcto unEstado) {
        return new RespondioBien();
    }

    @Override
    public EstadoDeRespuesta esCorrecta(Estado valor) {
        return valor.esCorrecta(this);
    }

    public EstadoDeRespuesta esCorrecta(Incorrecto unEstado) {
        return new RespondioMal();
    }
}
