package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

import java.util.Collection;

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
		this.verificarPosicionValida(posicion);
		opciones.agregarOpcionCorrecta(posicion);
	}
	
	private void verificarPosicionValida(int posicion) throws PosicionInvalidaException {
		if( ( posicion < 0 ) || ( posicion > this.getCantidadOpciones() ) ) {
			throw new PosicionInvalidaException();
		}
	}
	
	public abstract void calificarRespuesta(Respuesta respuesta);
	
	public Respuesta getModeloDeRespuesta(Jugador jugador) {
		jugador.setPreguntaActual(this);
		return new Respuesta(jugador, this.opciones.size());
	}


	public abstract Puntaje obtenerPuntuacion(EstadoDeRespuesta estado);
	
	/*public void calificarRespuestas(Collection<Respuesta> respuestas){
		for (Respuesta res: respuestas) {
			res.calificarMismaRespuesta(this.opciones);
		}
	}*/
}
