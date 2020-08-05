package edu.fiuba.algo3.modelo2.Preguntas;

import edu.fiuba.algo3.modelo2.ColeccionDeOpciones;
import edu.fiuba.algo3.modelo2.EstadosDeRespuesta.RespondeMal;
import edu.fiuba.algo3.modelo2.Opcion;
import edu.fiuba.algo3.modelo2.OpcionCorrecta;
import edu.fiuba.algo3.modelo2.OpcionIncorrecta;
import edu.fiuba.algo3.modelo2.Puntos.*;

import java.util.LinkedList;

public class PreguntaVerdaderoFalsoPenalidad extends PreguntaVerdaderoFalso {

    public PreguntaVerdaderoFalsoPenalidad(LinkedList<Opcion> opciones) {
        super(opciones);
    }

    public Punto calificarOpcion(Opcion opcion){
        return opcion.validarOpcion(this);
    }

    public Punto calificarOpcion(OpcionCorrecta opcion){
        return new PuntoPositivo();
    }

    public Punto calificarOpcion(OpcionIncorrecta opcion){
        return new PuntoNegativo();
    }
}
