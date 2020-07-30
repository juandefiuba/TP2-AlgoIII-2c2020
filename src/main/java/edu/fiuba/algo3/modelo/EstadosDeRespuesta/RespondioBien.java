package edu.fiuba.algo3.modelo.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Puntaje;

public class RespondioBien implements EstadoDeRespuesta {

    @Override
    public Puntaje devolverPuntaje(Pregunta unaPregunta){
        return new Puntaje(1);
    }

    @Override
    public Puntaje devolverPuntaje(PreguntaVerdaderoFalsoPenalidad unaPregunta) {
        return new Puntaje(1);
    }

    @Override
    public boolean todoBien() {
        return true;
    }
}
