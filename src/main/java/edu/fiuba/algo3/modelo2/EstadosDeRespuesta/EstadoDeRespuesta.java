package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Punto;

public interface EstadoDeRespuesta {

    EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual);
    EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual);

    Punto obtenerPuntajeSegunRespuesta(Pregunta pregunta);
}
