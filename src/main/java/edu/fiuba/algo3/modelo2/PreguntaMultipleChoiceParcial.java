package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public int calificarRespuesta(RespondeBien unEstadoRespuesta) {
        return 1;
    }

    @Override
    public int calificarRespuesta(RespondeMal unEstadoRespuesta) {
        return 0;
    }
}
