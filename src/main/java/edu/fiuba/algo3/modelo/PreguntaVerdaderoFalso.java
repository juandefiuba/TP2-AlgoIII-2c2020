package edu.fiuba.algo3.modelo;


public class PreguntaVerdaderoFalso extends Pregunta {
	
	private PreguntaVerdaderoFalso() {
		super(2);
	}
	
	public static PreguntaVerdaderoFalso newPreguntaVerdadera() {
		PreguntaVerdaderoFalso nuevaPregunta = new PreguntaVerdaderoFalso();
		nuevaPregunta.agregarOpcionCorrecta(1);
		return nuevaPregunta;
	}
	
	public static PreguntaVerdaderoFalso newPreguntaFalsa() {
		PreguntaVerdaderoFalso nuevaPregunta = new PreguntaVerdaderoFalso();
		nuevaPregunta.agregarOpcionCorrecta(2);
		return nuevaPregunta;
	}
	
	public Boolean esPreguntaVerdadera() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarMismaRespuesta(this.opciones);
		
	}
	
}
