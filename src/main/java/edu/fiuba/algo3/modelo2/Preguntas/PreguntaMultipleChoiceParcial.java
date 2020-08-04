package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public Puntaje calificarRespuesta(RespondeBien unEstadoRespuesta) {
        return unEstadoRespuesta.obtenerPuntaje();
    }

}
