package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeOpcion.Estado;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class PreguntaVerdaderoFalso extends Pregunta {
	
	protected PreguntaVerdaderoFalso() {
		super(2);
	}

	public static PreguntaVerdaderoFalso preguntaVerdadera(){
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso();
		pregunta.agregarOpcionCorrecta(1);
		return pregunta;
	}
	public static PreguntaVerdaderoFalso preguntaFalsa(){
		PreguntaVerdaderoFalso pregunta = new PreguntaVerdaderoFalso();
		pregunta.agregarOpcionCorrecta(2);
		return pregunta;
	}
	
	public Estado getRespuestaCorrecta() {
		return this.opciones.obtener(1).esCorrecta();// [C , I] [I , C]
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
