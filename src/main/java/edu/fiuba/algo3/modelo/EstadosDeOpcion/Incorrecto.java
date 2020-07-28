package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

public class Incorrecto extends Estado {

    public EstadoDeRespuesta esCorrecta() {
        return new RespondioBien();
    }

    public EstadoDeRespuesta esCorrecta(Correcto unEstado) {
        return new RespondioMal();
    }

    @Override
    public EstadoDeRespuesta esCorrecta(Estado valor) {
        return valor.esCorrecta();
    }
}
