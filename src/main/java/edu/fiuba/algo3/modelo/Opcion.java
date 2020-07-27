package edu.fiuba.algo3.modelo;

public class Opcion {
	
	private Boolean valor;
	private Natural posicion; /* para pregunta tipo OrderChoice */
	
	public Opcion() {
		this.valor = false;
	}
	
	public void definirCorrecta() {
		this.valor = true;
	}
	
	public void definirIncorrecta() {
		this.valor = false;
	}
	
	public Boolean mismoValor(Opcion otraOpcion) {
		return this.valor == otraOpcion.valor;
	}
	
	public Boolean esCorrecta() {
		return this.valor;
	}

}
