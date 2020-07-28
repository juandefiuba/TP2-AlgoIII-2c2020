package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso extends Pregunta {
	
	public PreguntaVerdaderoFalso(Boolean verdadera) {
		super(2);
		if(verdadera) {
			this.agregarOpcionCorrecta(1);
		} else {
			this.agregarOpcionCorrecta(2);
		}
	}
	
	public Boolean getRespuestaCorrecta() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarMismaRespuesta(this.opciones);
		
	}
	
}
