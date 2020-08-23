package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaBase;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Turno {
	private Queue<Jugador> jugadores;
	private Iterator preguntas;
	private Pregunta preguntaActual;

	public void iniciarJuegoCon(LinkedList<Jugador> jugadores, Iterator<Pregunta> preguntas) {
		this.jugadores = jugadores;
		this.preguntas = preguntas;
		this.preguntaActual = (Pregunta) this.preguntas.next();
	}
	
	public PreguntaBase obtenerPregunta() {
		return (PreguntaBase) this.preguntaActual;
	}

	public void avanzarJugador() {
		jugadores.add(jugadores.remove());
	}

	private void avanzarPregunta() {
		if(sigueElJuego()) {
			this.preguntaActual = (Pregunta) preguntas.next();
		}
	}

	public boolean sigueElJuego() {
		return this.preguntas.hasNext();
	}

	public void agregarRespuestaDeJugadorActual(LinkedList<Opcion> respuestas) {
		this.preguntaActual.agregarRespuestaDeJugador(this.jugadorActual(), respuestas);
	}

	public void agregarOpcionElegida(Opcion opcion) {
		this.preguntaActual.agregarRespuestaDeJugador(this.jugadorActual(), opcion);
	}

	public void removerOpcionElegida(Opcion opcion) {
		this.preguntaActual.removerRespuestaDeJugador(this.jugadorActual(), opcion);
	}

	public Jugador jugadorActual() {
		return jugadores.peek();
	}

	public void terminarTurno() {
		Jugador jugador = jugadorActual();
		avanzarJugador();
		this.preguntaActual.puntuarJugadores(jugadorActual(), jugador);
		this.avanzarPregunta();
	}

	public void activarMultiplicadorPorDos() {
		this.jugadorActual().activarMultiplicadorPorDos();
	}

	public void activarMultiplicadorPorTres() {
		this.jugadorActual().activarMultiplicadorPorTres();
	}
	
	public void activarExclusividad() {
		this.jugadorActual().activarExclusividad();
	}
}
