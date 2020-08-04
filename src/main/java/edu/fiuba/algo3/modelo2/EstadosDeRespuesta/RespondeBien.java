package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;

public class RespondeBien implements EstadoDeRespuesta {

    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual) {
        return new RespondeBien();
    }

    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual) { return new RespondeMal(); }

    @Override
    public int obtenerPuntajeSegunRespuesta(Pregunta pregunta) {
        return pregunta.calificarRespuesta(this);
    }
}
