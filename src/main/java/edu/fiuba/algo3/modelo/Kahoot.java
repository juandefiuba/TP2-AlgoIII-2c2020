package edu.fiuba.algo3.modelo;


import edu.fiuba.algo3.Lector;
import edu.fiuba.algo3.modelo.Excepciones.NoHayJugadoresException;
import edu.fiuba.algo3.modelo.Excepciones.NoHayPreguntasException;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

public class Kahoot { //Singleton
	private static Kahoot kahoot = null;
	private LinkedList<Jugador> jugadores;
	private LinkedList<Pregunta> preguntas;
	private Turno turno;
	private LinkedList<Opcion> opcionesElegidasTurnoActual;

	private Kahoot(String ruta) throws IOException {
		this.jugadores = new LinkedList<>();
		this.preguntas = this.leerPreguntas(ruta);
		this.turno = new Turno();
		this.opcionesElegidasTurnoActual = new LinkedList<>();
	}

	public static Kahoot Kahoot(String ruta) throws IOException {
		if (kahoot == null) {
			kahoot = new Kahoot(ruta);
		}

		return kahoot;
	}

	private LinkedList<Pregunta> leerPreguntas(String ruta) throws IOException {
		Lector lector = new Lector(ruta);
		return lector.obtenerPreguntas();
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
		this.opcionesElegidasTurnoActual.clear();
	}

	public void agregarRespuestaDeJugadorActual(LinkedList<Opcion> respuestas) {
		this.turno.agregarRespuestaDeJugadorActual(respuestas);
	}
	
	public void agregarOpcionElegida(Opcion opcion) {
		this.turno.agregarOpcionElegida(opcion);
		this.opcionesElegidasTurnoActual.add(opcion);
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
	
	public Pregunta obtenerPreguntaActual() {
		return this.turno.obtenerPregunta();
	}
	
	public Jugador obtenerJugadorActual() {
		return this.turno.jugadorActual();
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

	public void removerOpcionElegida(Opcion opcion) { this.turno.removerOpcionElegida(opcion); }

	public void removerOpcionesElegidas() {
		for (Opcion opcion: opcionesElegidasTurnoActual) {
			removerOpcionElegida(opcion);
		}
		this.opcionesElegidasTurnoActual.clear();
	}

	public Iterator<Opcion> getOpcionesElegidasTurnoActual() {
		return this.opcionesElegidasTurnoActual.iterator();
	}
}
