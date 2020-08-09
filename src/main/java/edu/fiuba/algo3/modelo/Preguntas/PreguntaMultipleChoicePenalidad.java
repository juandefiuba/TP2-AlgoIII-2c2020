package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Opcion;
import edu.fiuba.algo3.modelo.OpcionCorrecta;
import edu.fiuba.algo3.modelo.OpcionIncorrecta;
import edu.fiuba.algo3.modelo.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaMultipleChoicePenalidad extends Pregunta {

    public PreguntaMultipleChoicePenalidad(LinkedList<Opcion> opcionesDeLaPregunta) {
        super(opcionesDeLaPregunta);
    }

    @Override
    public void calificarOpcion(OpcionCorrecta opcion) {

        this.puntajeDelJugador.sumarPuntos(new PuntoPositivo());
    }

    @Override
    public void calificarOpcion(OpcionIncorrecta opcion) {
        this.puntajeDelJugador.sumarPuntos(new PuntoNegativo());
    }
}
