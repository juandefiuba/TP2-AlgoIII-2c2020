package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import java.util.LinkedList;

public class OpcionGrupoDos implements Opcion {

    @Override
    public void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {}

    @Override
    public void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno) {}

    @Override
    public void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos) {
        opcionesgrupoDos.add(this);
    }

    @Override
    public void validarOpcion(Pregunta pregunta) {}
}
