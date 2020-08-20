package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionCorrecta extends Opcion{

    @Override
    public void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {
        opcionesCorrectas.add(this);
    }

    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarRespuesta(new RespondeBien());
    }

}
