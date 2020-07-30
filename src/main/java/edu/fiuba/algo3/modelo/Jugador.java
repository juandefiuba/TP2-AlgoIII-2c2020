package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class Jugador {
	
	private String nombre;
	private Puntaje puntos;
	private Pregunta preguntaActual;

	public Jugador(String nombre) {
		this.nombre = nombre;
		this.puntos = new Puntaje(0);
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getPuntos() {
		return this.puntos.getPuntos();
	}
	
	public void asignarPuntos(Puntaje puntos) {
		this.puntos.agregarPuntos(puntos);
	}

	public void asignarPuntos(EstadoDeRespuesta estado) {
		Puntaje puntajeAux = preguntaActual.obtenerPuntuacion(estado);
		this.puntos.agregarPuntos(puntajeAux);
	}

	public void setPreguntaActual(Pregunta pregunta) {
		preguntaActual = pregunta;
	}
}
