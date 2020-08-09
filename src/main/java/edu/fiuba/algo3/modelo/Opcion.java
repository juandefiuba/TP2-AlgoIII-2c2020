package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public interface Opcion {

    void agregarJugadorQueLaEligio(Jugador jugador);

    void obtenerLRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador);

    void agregarOpcionesCorrectasNoElegidas(Jugador jugador, LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador);

    void validarOpcion(Pregunta pregunta);
}
