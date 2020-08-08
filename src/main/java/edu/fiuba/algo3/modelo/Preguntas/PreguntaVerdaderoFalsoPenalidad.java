package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntos.*;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {

    public PreguntaVerdaderoFalsoPenalidad(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    public Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador){
        return opcion.validarOpcion(this, puntajeDelJugador);
    }

    public Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta){
        puntajeDeRespuesta.sumarPuntos(new PuntoPositivo());
        return puntajeDeRespuesta;
    }

    public Puntaje calificarOpcion(OpcionIncorrecta opcion, Puntaje puntajeDeRespuesta) {
        puntajeDeRespuesta.sumarPuntos(new PuntoNegativo());
        return puntajeDeRespuesta;
    }
}
