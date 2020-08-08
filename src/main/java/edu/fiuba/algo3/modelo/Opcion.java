package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Puntos.Puntaje;

import java.util.LinkedList;

public interface Opcion {

    void agregarJugadorQueLaEligio(Jugador jugador);

    void obtenerLRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador);

    Puntaje validarOpcion(Pregunta pregunta, Puntaje puntajeDeRespuesta);

    void agregarOpcionesCorrectasNoElegidas(Jugador jugador, LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador);
}
