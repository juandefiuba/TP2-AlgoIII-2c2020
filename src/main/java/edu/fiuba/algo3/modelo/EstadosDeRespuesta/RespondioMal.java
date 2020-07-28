package edu.fiuba.algo3.modelo.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalso;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Puntaje;

public class RespondioMal implements EstadoDeRespuesta {


    public Puntaje devolverPuntaje(PreguntaVerdaderoFalsoPenalidad unaPregunta){
        return new Puntaje(-1);
    }

    @Override
    public Puntaje devolverPuntaje(Pregunta unaPregunta){
        return new Puntaje(0);
    }



}
