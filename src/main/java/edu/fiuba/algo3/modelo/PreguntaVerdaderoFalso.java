package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso extends Pregunta {
	
	public PreguntaVerdaderoFalso() {
		super(2);
		/*if(verdadera) {
			this.agregarOpcionCorrecta(1);
		} else {
			this.agregarOpcionCorrecta(0);
		}*/
	}

	public static PreguntaVerdaderoFalso preguntaVerdadera(){
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso();
		pregunta.agregarOpcionCorrecta(1);
		return pregunta;
	}
	public static PreguntaVerdaderoFalso preguntaFalsa(){
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso();
		pregunta.agregarOpcionCorrecta(0);
		return pregunta;
	}
	
	public Boolean getRespuestaCorrecta() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarMismaRespuesta(this.opciones);
		
	}
	
}
