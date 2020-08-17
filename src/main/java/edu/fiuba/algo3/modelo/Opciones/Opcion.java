package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public interface Opcion {

    void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas);
    void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno);
    void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos);
    void validarOpcion(Pregunta pregunta);
}