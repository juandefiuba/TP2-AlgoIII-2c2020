package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.Opcion;
import edu.fiuba.algo3.modelo2.OpcionCorrecta;
import edu.fiuba.algo3.modelo2.OpcionIncorrecta;
import edu.fiuba.algo3.modelo2.Puntos.*;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(LinkedList<Opcion> opciones) {
        super(opciones);
    }



    public Puntaje calificarOpcion(OpcionIncorrecta opcion, Puntaje puntajeDeRespuesta) {
        puntajeDeRespuesta.sumarPuntos(new PuntoNegativo());
        return puntajeDeRespuesta;
    }
}
