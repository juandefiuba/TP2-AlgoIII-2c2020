package edu.fiuba.algo3.modelo;

public class Jugador {
	
	private String nombre;
	private Puntaje puntos;

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
}
