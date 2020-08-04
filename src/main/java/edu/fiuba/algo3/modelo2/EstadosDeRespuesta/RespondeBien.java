package edu.fiuba.algo3.modelo2.EstadosDeRespuesta;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

public class RespondeBien implements EstadoDeRespuesta {

    Puntaje puntajeAcumulado;

    public RespondeBien(){
        this.puntajeAcumulado = new Puntaje();
    }
    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeBien estadoActual) {
        this.puntajeAcumulado.sumarPuntos(new PuntoPositivo());
        return this;
    }

    @Override
    public EstadoDeRespuesta actualizarEstado(RespondeMal estadoActual) { return new RespondeMal(); }

    @Override
    public Puntaje obtenerPuntajeSegunRespuesta(Pregunta pregunta) {
        return pregunta.calificarRespuesta(this);
    }

    public Puntaje obtenerPuntaje() {
        return puntajeAcumulado;
    }
}
