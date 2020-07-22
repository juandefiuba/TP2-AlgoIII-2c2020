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
	
	public String getProblema(){
		return this.problema;
	}
	
	/* Dice si la respuestaElegida es igual a la respuesta correcta
	 * Equivale a sacarse el mayor puntaje posible */
	public boolean esCorrecto(Respuesta respuestaElegida) {
		return this.respuestaCorrecta.igualA(respuestaElegida);
	}
	
	public ArrayList<String> getOpciones() {
		return this.opciones;
	}
	
	public int calificarRespuesta(Respuesta respuestaElecgida) {
		return this.respuestaCorrecta.comparar(respuestaElecgida);
	}
	
}
