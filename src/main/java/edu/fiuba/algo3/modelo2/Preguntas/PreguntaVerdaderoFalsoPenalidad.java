package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNegativo;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNeutro;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public Puntaje calificarRespuesta(RespondeMal unEstadoRespuesta){
        Puntaje puntajeADevolver = new Puntaje();
        puntajeADevolver.sumarPuntos(new PuntoNegativo());
        return puntajeADevolver;
    }
}
