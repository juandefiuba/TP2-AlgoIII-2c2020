package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pregunta {
	
	private String problema;
	private Respuesta respuestaCorrecta;
	private ArrayList<String> opciones;
	
	public Pregunta(String problema, Respuesta respuesta, ArrayList<String> opciones) {
		this.problema = problema;
		this.respuestaCorrecta = respuesta;
		this.opciones = new ArrayList<String>();
		this.opciones.addAll(opciones);
	}
	
	public static Pregunta crearPreguntaVerdaderoFalso(String problema, RespuestaVerdaderoFalso respuesta) {
		ArrayList<String> opciones = new ArrayList<String>();
		opciones.add("Verdadero");
		opciones.add("Falso");
		return new Pregunta(problema, respuesta, opciones);
	}


	public String getProblema() {
		return this.problema;
	}


	public ArrayList<String> getOpciones() {
		return this.opciones;
	}


	public int calificarRespuesta(Respuesta respuestaElegida) {
		return this.respuestaCorrecta.comparar(respuestaElegida);
	}

	public void calificarJugador(Respuesta respuesta)
	{
		respuesta.calificarJugador(this.calificarRespuesta(respuesta));
	}

	public void calificarJugadores(ArrayList<Respuesta> respuestas)
	{
		for (Respuesta i: respuestas)
			this.calificarJugador(i);
	}
}
