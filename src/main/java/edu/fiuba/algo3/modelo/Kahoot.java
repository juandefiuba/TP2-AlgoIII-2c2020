package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.modelo.Excepciones.NoHayJugadoresException;
import edu.fiuba.algo3.modelo.Excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaBase;

import java.util.LinkedList;

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
		if (this.preguntas.isEmpty()) {
			throw new NoHayPreguntasException();
		}

		if (this.jugadores.isEmpty()) {
			throw new NoHayJugadoresException();
		}

		this.turno.iniciarJuegoCon(this.jugadores, this.preguntas.iterator());
	}
	
	public static void resetear() {
		kahoot = null;
	}

	public void agregarJugador(String nombreJugador) {
		Jugador jugador = new Jugador();
		jugador.nombrar(nombreJugador);
		this.jugadores.add(jugador);
	}
	
	public LinkedList<Jugador> obtenerJugadores(){
		return this.jugadores;
	}

	public void avanzarAProximoJugador() {
		this.turno.avanzarJugador();
	}

	public void agregarRespuestaDeJugadorActual(LinkedList<Opcion> respuestas) {
		this.turno.agregarRespuestaDeJugadorActual(respuestas);
	}
	
	public void agregarOpcionElegida(Opcion opcion) {
		this.turno.agregarOpcionElegida(opcion);
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
	
	public PreguntaBase obtenerPreguntaActual() {
		return this.turno.obtenerPregunta();
	}

	public void activarMultiplicadorPorDos() {
		this.turno.activarMultiplicadorPorDos();
	}

	public void activarMultiplicadorPorTres() {
		this.turno.activarMultiplicadorPorTres();
	}
	
	public void activarExclusividad() {
		this.turno.activarExclusividad();
	}
}
