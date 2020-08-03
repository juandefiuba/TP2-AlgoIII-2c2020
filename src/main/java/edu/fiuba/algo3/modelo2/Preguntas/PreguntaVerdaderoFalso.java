package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.Jugador;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;

import java.util.Iterator;
import java.util.LinkedList;

public class PreguntaVerdaderoFalso extends Pregunta{

    private ColeccionDeOpciones opciones;
    private LinkedList<Jugador> jugadores;

    public PreguntaVerdaderoFalso(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    public int calificarRespuesta(RespondeBien unEstadoRespuesta){
        return 1;
    }

    public int calificarRespuesta(RespondeMal unEstadoRespuesta){
        return 0;
    }
}
