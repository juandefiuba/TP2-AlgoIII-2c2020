package edu.fiuba.algo3.modelo;


public class PreguntaVerdaderoFalsoPenalidad extends Pregunta {

	private PreguntaVerdaderoFalsoPenalidad() {
		super(2);
	}
	
	public static PreguntaVerdaderoFalsoPenalidad newPreguntaVerdadera() {
		PreguntaVerdaderoFalsoPenalidad nuevaPregunta = new PreguntaVerdaderoFalsoPenalidad();
		nuevaPregunta.agregarOpcionCorrecta(1);
		return nuevaPregunta;
	}
	
	public static PreguntaVerdaderoFalsoPenalidad newPreguntaFalsa() {
		PreguntaVerdaderoFalsoPenalidad nuevaPregunta = new PreguntaVerdaderoFalsoPenalidad();
		nuevaPregunta.agregarOpcionCorrecta(2);
		return nuevaPregunta;
	}
	
	public Boolean esPreguntaVerdadera() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarRespuestaConPenalidad(this.opciones);
	}

}
