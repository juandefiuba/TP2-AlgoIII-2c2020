package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Preguntas.Pregunta;

import java.util.LinkedList;

public abstract class Opcion {

	private String texto;
	public void setearTexto(String texto) {
		this.texto = texto;
	}
	public String obtenerTexto() {
		return this.texto;
	}
    public abstract void enlistarOpcionesCorrectas(LinkedList<Opcion> opcionesCorrectas);
	public abstract void validarOpcion(Pregunta pregunta);
}
