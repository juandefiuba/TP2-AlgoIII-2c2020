package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionIncorrecta extends Opcion{

    @Override
    public void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {}

    @Override
    public void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno) {}

    @Override
    public void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos) {}

    @Override
    public void validarOpcion(Pregunta pregunta) {
        pregunta.calificarRespuesta(new RespondeMal());
    }
}
