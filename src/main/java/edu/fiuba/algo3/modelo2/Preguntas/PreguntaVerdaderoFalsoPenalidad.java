package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(ColeccionDeOpciones opciones) {
        super(opciones);
    }

    @Override
    public int calificarRespuesta(RespondeMal unEstadoRespuesta){ return -1; }

}
