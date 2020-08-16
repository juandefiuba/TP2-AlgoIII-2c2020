package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public class OpcionGrupoUno implements Opcion {


    @Override
    public void agregarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas) {

    }

    @Override
    public void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno) {
        opcionesgrupoUno.add(this);
    }

    @Override
    public void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos) {

    }

    @Override
    public void validarOpcion(Pregunta pregunta) {

    }
}
