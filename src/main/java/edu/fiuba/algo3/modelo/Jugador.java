package edu.fiuba.algo3.modelo;

public class Jugador {
	
	private String nombre;
	private Puntaje puntos;

	public void asignarPuntos(Puntaje puntos) {
		this.puntos.agregarPuntos(puntos);
	}
	
}
