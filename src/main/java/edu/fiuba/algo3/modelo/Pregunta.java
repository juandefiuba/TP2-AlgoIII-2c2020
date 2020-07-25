package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public abstract class Pregunta {
	
	protected ArrayList<Opcion> opciones;
	
	protected Pregunta(Natural cantidadOpciones) {
		// TODO: verificar cantidad minima de opciones
		this.opciones = new ArrayList<Opcion>();
		for(int i = 1; i <= cantidadOpciones.getNumero(); i++) {
			opciones.add( new Opcion(false) );
		}
	}
	
	public int getCantidadOpciones() {
		return this.opciones.size();
	}
	
	public void agregarOpcionCorrecta(Natural posicion) {
		this.opciones.get( posicion.getNumero() ).definirCorrecta();
	}
	
	public abstract void calificarRespuesta(Respuesta respuesta);
	
	// public Respuesta getModeloDeRespuesta() ?

}
