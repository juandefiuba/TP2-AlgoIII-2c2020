package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;

public interface EstadoDeRespuesta {

    EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual);
    EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual);

    int obtenerPuntajeSegunRespuesta(Pregunta pregunta);
}
