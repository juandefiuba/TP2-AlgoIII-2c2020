package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

public class Falso extends Estado {

    public EstadoDeRespuesta esCorrecta(Falso unEstado) {
        return new RespondioBien();
    }

    public EstadoDeRespuesta esCorrecta(Verdadero unEstado) {
        return new RespondioMal();
    }

    @Override
    public EstadoDeRespuesta esCorrecta(Estado valor) {
        return valor.esCorrecta(this);
    }
}
