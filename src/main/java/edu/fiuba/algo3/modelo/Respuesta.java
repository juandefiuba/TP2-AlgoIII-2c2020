package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;
import edu.fiuba.algo3.modelo.EstadosDeRespuesta.RespondioBien;

import java.util.ArrayList;

public class Respuesta {
	
	private Jugador jugador;
	private ArrayList<Opcion> selecciones;
	public EstadoDeRespuesta estadoDeRespuesta;
	
	public Respuesta(Jugador jugador, int cantidadOpciones) {
		// me gustaria buscar una manera de que solo la clase Pregunta pueda llamar este constructor
		this.jugador = jugador;
		this.selecciones = new ArrayList<>();
		for(int i = 1; i <= cantidadOpciones; i++) {
			selecciones.add( new Opcion() );
		}
	}
	
	public void agregarOpcionCorrecta(int opcion) {
		this.verificarOpcionValida(opcion);
		this.selecciones.get(opcion).definirCorrecta();
	}
	
	private void verificarOpcionValida(int opcion) throws PosicionInvalidaException {
		if( ( opcion < 0 ) || ( opcion > this.selecciones.size() ) ) {
			throw new PosicionInvalidaException();
		}
	}
	
	public void calificarMismaRespuesta(ArrayList<Opcion> respuestaCorrecta) {
		/* si las respuesta son iguales suma 1 punto al jugador */
		int i = 1;
		while( i < selecciones.size() ){
			estadoDeRespuesta = selecciones.get(i).mismoValor(respuestaCorrecta.get(i));
			i++;
		}
		this.jugador.asignarPuntos(estadoDeRespuesta);
	}

}
