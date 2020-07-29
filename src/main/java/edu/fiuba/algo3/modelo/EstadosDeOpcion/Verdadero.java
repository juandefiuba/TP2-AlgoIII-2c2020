package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

public class Verdadero extends Estado {

    public EstadoDeRespuesta esCorrecta(Verdadero unEstado) {
        return new RespondioBien();
    }

    @Override
    public EstadoDeRespuesta esCorrecta(Estado valor) {
        return valor.esCorrecta(this);
    }

    public EstadoDeRespuesta esCorrecta(Falso unEstado) {
        return new RespondioMal();
    }
}
