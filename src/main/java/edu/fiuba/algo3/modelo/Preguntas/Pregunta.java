package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Excepciones.FaltanOpcionesEnLaPreguntaException;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeBien;
import edu.fiuba.algo3.modelo.Opciones.EstadoDeCalificacion.RespondeMal;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Puntajes.Puntaje;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeNulo;
import edu.fiuba.algo3.modelo.Puntajes.PuntajeValido;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public abstract class Pregunta{

	protected LinkedList<Opcion> opciones;
	protected Map<Jugador, LinkedList<Opcion>> respuestasDeLosJugadores;
	protected String texto;

	protected Puntaje puntajeDelJugador;

	protected Pregunta(LinkedList<Opcion> opcionesDeLaPregunta) {
		if(opcionesDeLaPregunta.size() < 2){
			throw new FaltanOpcionesEnLaPreguntaException();
		}
		this.puntajeDelJugador = new PuntajeNulo();
		this.opciones = opcionesDeLaPregunta;
		this.respuestasDeLosJugadores = new HashMap<>();
	}

	public abstract void puntuarJugadores(Jugador jugador, Jugador jugador2);
	public abstract void calificarRespuesta(RespondeBien calificador);
	public abstract void calificarRespuesta(RespondeMal calificador);

	public void setearTexto(String texto) {
		this.texto = texto;
	}
	
	public String obtenerTexto() {
		return this.texto;
	}

	public void agregarRespuestaDeJugador(Jugador jugador, LinkedList<Opcion> respuestas){
		this.respuestasDeLosJugadores.put(jugador, respuestas);
	}

	public void agregarRespuestaDeJugador(Jugador jugador, Opcion opcion){
		if (this.respuestasDeLosJugadores.containsKey(jugador)) {
			this.respuestasDeLosJugadores.get(jugador).add(opcion);
		} else {
			LinkedList<Opcion> respuestas = new LinkedList<Opcion>();
			respuestas.add(opcion);
			this.agregarRespuestaDeJugador(jugador, respuestas);
		}
	}

	public void removerRespuestaDeJugador(Jugador jugador, Opcion opcion) {
		this.respuestasDeLosJugadores.get(jugador).remove(opcion);
	}

	public void calificarRespuesta(Opcion opcion){
		opcion.validarOpcion(this);
	}

	protected Puntaje obtenerPuntajeBaseDelJugador(Jugador unJugador) {

		this.puntajeDelJugador = new PuntajeValido();
		LinkedList<Opcion> respuestaDelJugador = this.respuestasDeLosJugadores.get(unJugador);

		respuestaDelJugador.forEach(opcion -> this.calificarRespuesta(opcion));
		return this.puntajeDelJugador;
	}

	public boolean respondio(Jugador jugador) {
		return this.respuestasDeLosJugadores.containsKey(jugador);
	}

	public Iterator<Opcion> obtenerOpciones() {
		return opciones.iterator();
	}
}
