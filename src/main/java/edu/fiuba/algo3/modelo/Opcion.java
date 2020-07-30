package edu.fiuba.algo3.modelo;

public class Opcion {
	
	private EstadoOpcion valor;
	// private Natural posicion; /* para pregunta tipo OrderChoice */
	
	public Opcion() {
		this.valor = new Destildado();
	}
	
	public void definirCorrecta() {
		this.valor = new Tildado();
	}
	
	public void definirIncorrecta() {
		this.valor = new Destildado();
	}
	
	public Boolean mismoValor(Opcion otraOpcion) {
		return this.valor.mismoValor(otraOpcion.valor);
	}
	
	public Integer puntuarOpcion(Opcion otraOpcion) {
		return this.valor.puntajeObtendido(otraOpcion.valor);
	}
	
	public Boolean esCorrecta() {
		return this.valor.estado();
	}

}
