package edu.fiuba.algo3.modelo.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo.Puntaje;

public class RespondioMal implements EstadoDeRespuesta {

    @Override
    public Puntaje devolverPuntaje(){
        return new Puntaje(0);
    }
}
