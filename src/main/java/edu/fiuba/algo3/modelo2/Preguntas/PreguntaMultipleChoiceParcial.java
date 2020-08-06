package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.Opcion;
import edu.fiuba.algo3.modelo2.OpcionCorrecta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoiceParcial extends Pregunta{

    public PreguntaMultipleChoiceParcial(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    @Override
    public Puntaje calificarOpcion(Opcion opcion, Puntaje puntajeDelJugador) {
        return opcion.validarOpcion(this, puntajeDelJugador);
    }

    @Override
    public Puntaje calificarOpcion(OpcionCorrecta opcion, Puntaje puntajeDeRespuesta) {
        puntajeDeRespuesta.sumarPuntos(new PuntoPositivo());
        return puntajeDeRespuesta;
    }

}
