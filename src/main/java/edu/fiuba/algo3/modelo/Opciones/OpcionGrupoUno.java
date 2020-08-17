package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import java.util.LinkedList;

public class OpcionGrupoUno implements Opcion {

    @Override
    public void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {}

    @Override
    public void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno) {
        opcionesgrupoUno.add(this);
    }

    @Override
    public void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos) {}

    @Override
    public void validarOpcion(Pregunta pregunta) {}
}
