package edu.fiuba.algo3.modelo.Opcion;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public interface Opcion {

    void agregarJugadorQueLaEligio(Jugador jugador);

    void agregarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas);

    void validarOpcion(Pregunta pregunta);

}
