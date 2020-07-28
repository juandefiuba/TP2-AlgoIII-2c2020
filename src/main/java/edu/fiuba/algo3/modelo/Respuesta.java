package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Respuesta {
	
	private Jugador jugador;
	private ArrayList<Opcion> selecciones;
	
	public Respuesta(Jugador jugador, int cantidadOpciones) {
		// me gustaria buscar una manera de que solo la clase Pregunta pueda llamar este constructor
		this.jugador = jugador;
		this.selecciones = new ArrayList<Opcion>();
		for(int i = 1; i <= cantidadOpciones; i++) {
			selecciones.add( new Opcion() );
		}
	}
	
	public void agregarOpcionCorrecta(int opcion) {
		this.verificarOpcionValida(opcion);
		this.selecciones.get(opcion).definirCorrecta();
	}
	
	private void verificarOpcionValida(int opcion) throws PosicionInvalidaException {
		if( ( opcion < 1 ) || ( opcion > this.selecciones.size() ) ) {
			throw new PosicionInvalidaException();
		}
	}
	
	public void calificarMismaRespuesta(ArrayList<Opcion> respuestaCorrecta) {
		/* si las respuesta son iguales suma 1 punto al jugador */
		Boolean iguales = true;
		int i = 1;
		while( (i < selecciones.size() ) && (iguales) ) {
			iguales = selecciones.get(i).mismoValor(respuestaCorrecta.get(i));
			i++;
		}
		if(iguales) {
			this.jugador.asignarPuntos( new Puntaje(1) );
		}
	}

}
