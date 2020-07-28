package edu.fiuba.algo3.modelo;

public class Puntaje {
	
	int puntos;
	
	public Puntaje(int puntos) {
		this.puntos = puntos;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public void agregarPuntos(Puntaje otroPuntaje) {
		this.puntos += otroPuntaje.puntos;
	}

}
