package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Opcion.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionCorrecta implements Opcion{

    @Override
    public void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {
        opcionesCorrectas.add(this);
    }

    @Override
    public void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno) {}

    @Override
    public void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos) {}

    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarRespuesta(new RespondeBien());
    }

}
