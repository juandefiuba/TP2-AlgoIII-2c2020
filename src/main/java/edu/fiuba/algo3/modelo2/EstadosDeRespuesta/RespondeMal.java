package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Punto;

public class RespondeMal implements EstadoDeRespuesta {

    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual) { return new RespondeMal(); }

    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual) {
        return new RespondeMal();
    }

    @Override
    public Punto obtenerPuntajeSegunRespuesta(Pregunta pregunta) { return pregunta.calificarRespuesta(this); }

}
