package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;

public interface EstadoDeRespuesta {

    EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual);
    EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual);

    Puntaje obtenerPuntajeSegunRespuesta(Pregunta pregunta);
}
