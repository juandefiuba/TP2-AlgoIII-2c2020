package edu.fiuba.algo3.modelo2;

import edu.fiuba.algo3.modelo2.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo2.Puntos.Puntaje;

import java.util.LinkedList;

public interface Opcion {

    void agregarJugadorQueLaEligio(Jugador jugador);

    void obtenerLRespuestaDelJugador(Jugador jugador, LinkedList<Opcion> respuestasDelJugador);

    Puntaje validarOpcion(Pregunta pregunta, Puntaje puntajeDeRespuesta);

    void agregarOpcionesCorrectasNoElegidas(Jugador jugador, LinkedList<Opcion> opcionesCorrectasNoElegidasPorElJugador);
}
