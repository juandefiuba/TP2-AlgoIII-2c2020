package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion.Opcion;
import edu.fiuba.algo3.modelo.Opcion.RespondeBien;
import edu.fiuba.algo3.modelo.Opcion.RespondeMal;
import edu.fiuba.algo3.modelo.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    public PreguntaMultipleChoicePenalidad(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    @Override
    public void calificarRespuesta(RespondeBien calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarRespuesta(RespondeMal calificador) {

        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }
}
