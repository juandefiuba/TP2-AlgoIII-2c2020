package edu.fiuba.algo3.modelo.Preguntas;

import edu.fiuba.algo3.modelo.Respuesta;
import edu.fiuba.algo3.modelo.Excepciones.CantidadOpcionesInvalidaException;

public class PreguntaMultipleChoiceParcial extends Pregunta {

	private static Integer minCantOpciones = 2;
	private static Integer maxCantOpciones = 5;

	private PreguntaMultipleChoiceParcial(Integer cantidadOpciones) {
			super(cantidadOpciones);
	}

	public static PreguntaMultipleChoiceParcial newPregunta(Integer cantidadOpciones) {
		verificarCantidadOpcionesValida(cantidadOpciones);
		PreguntaMultipleChoiceParcial nuevaPregunta = new PreguntaMultipleChoiceParcial(cantidadOpciones);
		return nuevaPregunta;
	}
	
	private static void verificarCantidadOpcionesValida(Integer cantidadOpciones) throws CantidadOpcionesInvalidaException {
		if (cantidadOpciones > maxCantOpciones || cantidadOpciones < minCantOpciones) {
			throw new CantidadOpcionesInvalidaException();
		}
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarRespuestaParcial(this.opciones);
	}

}
