package edu.fiuba.algo3.modelo.EstadosDeOpcion;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.*;

public class Correcto implements Estado {

    public EstadoDeRespuesta esCorrecta(Correcto unEstado) {
        return new RespondioBien();
    }
    //this == Correcto
    // unEstado== Correcto

    @Override
    public EstadoDeRespuesta esCorrecta(Estado valor) {
        return valor.esCorrecta(this);
            //Estado.esCorrecta(Correcto);
    }

    public EstadoDeRespuesta esCorrecta(Incorrecto unEstado) {
        return new RespondioMal();
    }
}
