package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.Jugador;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;

import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaMultipleChoiceClasico extends Pregunta {

    public PreguntaMultipleChoiceClasico(ColeccionDeOpciones opciones) {
        super(opciones);
   }

    @Override
    public int calificarRespuesta(RespondeBien unEstadoRespuesta){ return 1; }

    @Override
    public int calificarRespuesta(RespondeMal unEstadoRespuesta){ return 0; }
}
