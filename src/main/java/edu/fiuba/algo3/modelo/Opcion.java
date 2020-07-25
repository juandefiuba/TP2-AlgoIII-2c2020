package edu.fiuba.algo3.modelo;

public class Opcion {
	
	private Boolean correcta;
	private Natural posicion; /* para pregunta tipo OrderChoice */
	
	public Opcion(Boolean valor) {
		this.correcta = valor;
	}
	
	public void definirCorrecta() {
		this.correcta = true;
	}
	
	public Boolean esCorrecta() {
		return this.correcta;
	}

}
