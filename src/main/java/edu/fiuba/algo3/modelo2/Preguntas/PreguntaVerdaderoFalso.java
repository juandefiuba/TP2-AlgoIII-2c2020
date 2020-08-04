package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.Jugador;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.Punto;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

import java.util.LinkedList;

public class PreguntaVerdaderoFalso extends Pregunta{


    public PreguntaVerdaderoFalso(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    public Punto calificarRespuesta(RespondeBien unEstadoRespuesta){
        return new PuntoPositivo();
    }

    public Punto calificarRespuesta(RespondeMal unEstadoRespuesta){
        return new PuntoNeutro();
    }
}
