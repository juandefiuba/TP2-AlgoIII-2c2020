package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class PreguntaMultipleChoiceParcial extends Pregunta {
	private static Integer minCantOpciones = 2;
	private static Integer maxCantOpciones = 5;

	protected PreguntaMultipleChoiceParcial(int cantidadOpciones) {
			super(cantidadOpciones);
	}

	public static PreguntaMultipleChoiceParcial crearConCantOpciones(int cantidadOpciones) {
		if (cantidadOpciones > maxCantOpciones || cantidadOpciones < minCantOpciones) {
			throw new CantidadDeOpcionesInvalidaException();
		}

		PreguntaMultipleChoiceParcial pregunta = new PreguntaMultipleChoiceParcial(cantidadOpciones);
		return pregunta;
	}


	/*Por qué esto devuelve el estado??????????
	public Estado getRespuestaCorrecta() {
		return this.opciones.get(1).esCorrecta();
	}*/

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarMismaRespuesta(this.opciones);
	}

	@Override
	public Puntaje obtenerPuntuacion(EstadoDeRespuesta estado) {
		return estado.devolverPuntaje(this);
	}

}
