package edu.fiuba.algo3.modelo;

public class Puntaje {
	
	int puntos;
	
	public Puntaje(int puntosIniciales) {
		this.puntos = puntosIniciales;
	}
	
	public int getPuntos() {
		return this.puntos;
	}
	
	public void agregarPuntos(Puntaje otroPuntaje) {
		this.puntos += otroPuntaje.getPuntos();
	}

}
