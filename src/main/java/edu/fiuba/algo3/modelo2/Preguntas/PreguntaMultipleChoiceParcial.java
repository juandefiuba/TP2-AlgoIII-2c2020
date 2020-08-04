package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeBien;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.Punto;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;
import edu.fiuba.algo3.modelo2.Puntos.PuntoPositivo;

public class PreguntaMultipleChoiceParcial extends Pregunta {

    public PreguntaMultipleChoiceParcial(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public Punto calificarRespuesta(RespondeBien unEstadoRespuesta) {
        return new PuntoPositivo();
    }

    @Override
    public Punto calificarRespuesta(RespondeMal unEstadoRespuesta) {
        return new PuntoNeutro();
    }
}
