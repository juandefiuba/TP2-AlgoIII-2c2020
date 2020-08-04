package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Puntos.Punto;
import edu.fiuba.algo3.modelo2.Puntos.PuntoNegativo;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public Punto calificarRespuesta(RespondeMal unEstadoRespuesta){ return new PuntoNegativo(); }

}
