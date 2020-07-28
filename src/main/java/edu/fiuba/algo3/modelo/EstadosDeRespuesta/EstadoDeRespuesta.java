package edu.fiuba.algo3.modelo.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo.Pregunta;
import edu.fiuba.algo3.modelo.PreguntaVerdaderoFalsoPenalidad;
import edu.fiuba.algo3.modelo.Puntaje;

public interface EstadoDeRespuesta {

    Puntaje devolverPuntaje(Pregunta unaPregunta);
    Puntaje devolverPuntaje(PreguntaVerdaderoFalsoPenalidad unaPregunta);

}
