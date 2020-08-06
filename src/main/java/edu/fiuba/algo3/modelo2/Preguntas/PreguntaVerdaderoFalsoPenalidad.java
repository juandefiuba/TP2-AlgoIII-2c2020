package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.Opcion;
import edu.fiuba.algo3.modelo2.OpcionCorrecta;
import edu.fiuba.algo3.modelo2.OpcionIncorrecta;
import edu.fiuba.algo3.modelo2.Puntos.*;

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
