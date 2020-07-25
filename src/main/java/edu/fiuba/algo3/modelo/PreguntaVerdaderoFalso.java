package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso extends Pregunta {
	
	public PreguntaVerdaderoFalso(Boolean verdadera) {
		super(new Natural(2));
		if(verdadera) {
			this.agregarOpcionCorrecta(new Natural(1));
		} else {
			this.agregarOpcionCorrecta(new Natural(2));
		}
	}
	
	public Boolean getRespuestaCorrecta() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		// TODO Auto-generated method stub
		
	}
	
}
