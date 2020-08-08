package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.*;
import edu.fiuba.algo3.modelo.Puntos.*;
import java.util.LinkedList;

public class PreguntaVerdaderoFalso extends Pregunta{

    protected LinkedList<Opcion> opciones;

    public PreguntaVerdaderoFalso(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    public Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador){
        return opcion.validarOpcion(this, puntajeDelJugador);
    }

    public Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta){
        puntajeDeRespuesta.sumarPuntos(new PuntoPositivo());
        return puntajeDeRespuesta;
    }
}