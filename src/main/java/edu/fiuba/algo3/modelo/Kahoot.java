package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Kahoot { //Singleton
	private static Kahoot kahoot = null;
	private LinkedList<Jugador> jugadores;
	private LinkedList<Pregunta> preguntas;
	private Turno turno;

	private Kahoot() {
		this.jugadores = new LinkedList<>();
		this.preguntas = new LinkedList<>();
		this.turno = new Turno();
	}

	public static Kahoot Kahoot() {
		if (kahoot == null) {
			kahoot = new Kahoot();
		}

		return kahoot;
	}

	public void iniciarJuego() {
		this.turno.iniciarJuegoCon(this.jugadores, this.preguntas.iterator());
	}

	public void agregarJugador(String nombreJugador) {
		Jugador jugador = new Jugador();
		jugador.nombrar(nombreJugador);
		this.jugadores.add(jugador);
	}

	public void avanzarAProximoJugador() {
		this.turno.avanzarJugador();
	}

	public void agregarRespuestaDeJugadorActual(LinkedList<Opcion> respuestas) {
		this.turno.agregarRespuestaDeJugadorActual(respuestas);
	}

	public void agregarPregunta(Pregunta pregunta) {
		this.preguntas.add(pregunta);
	}

	public void terminarTurno() {
		this.turno.terminarTurno();
	}

	public boolean sigueElJuego() {
		return this.turno.sigueElJuego();
	}
}
