package edu.fiuba.algo3.modelo;


public abstract class Pregunta {
	
	protected ColeccionDeOpciones opciones;
	
	protected Pregunta(int cantidadOpciones) {
		/* Es responsabilidad de las clases hijas verificar que la cantidad de
		 * opciones sea valida */
		this.opciones = new ColeccionDeOpciones(cantidadOpciones);
	}
	
	public int getCantidadOpciones() {
		return this.opciones.size();
	}
	
	public void agregarOpcionCorrecta(int posicion) {
		this.opciones.tildarOpcion(posicion);
	}
	
	public abstract void calificarRespuesta(Respuesta respuesta);
	
	public Respuesta getModeloDeRespuesta(Jugador jugador) {
		return new Respuesta(jugador, this.opciones.size());
	}
}
