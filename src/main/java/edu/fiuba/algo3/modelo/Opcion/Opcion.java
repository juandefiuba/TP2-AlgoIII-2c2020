package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public interface Opcion {


    void agregarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas);

    void enlistarGrupoUno(LinkedList<Opcion> opcionesgrupoUno);
    void enlistarGrupoDos(LinkedList<Opcion> opcionesgrupoDos);
    void validarOpcion(Pregunta pregunta);

}
