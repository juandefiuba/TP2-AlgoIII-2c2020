package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Estado;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioMal;

import java.util.ArrayList;

public class PreguntaVerdaderoFalso extends Pregunta {
	
	public PreguntaVerdaderoFalso() {
		super(2);
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
	
	public Estado getRespuestaCorrecta() {
		return this.opciones.get(1).esCorrecta();
	}

	@Override
	public void calificarRespuesta(Respuesta respuesta) {
		respuesta.calificarMismaRespuesta(this.opciones);
	}

	@Override
	public Puntaje obtenerPuntuacion(EstadoDeRespuesta estado) {
		return estado.devolverPuntaje(this);
	}

}
