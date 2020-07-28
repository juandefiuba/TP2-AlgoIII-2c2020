package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

import java.util.ArrayList;

public abstract class Pregunta {
	
	protected ArrayList<Opcion> opciones;
	
	protected Pregunta(int cantidadOpciones) {
		/* Es responsabilidad de las clases hijas verificar que la cantidad de
		 * opciones sea valida */
		this.opciones = new ArrayList<>();
		for(int i = 1; i <= cantidadOpciones; i++) {
			opciones.add( new Opcion() );
		}
	}
	
	public int getCantidadOpciones() {
		return this.opciones.size();
	}
	
	public void agregarOpcionCorrecta(int posicion) {
		this.verificarPosicionValida(posicion);
		this.opciones.get(posicion).definirCorrecta();
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
}
