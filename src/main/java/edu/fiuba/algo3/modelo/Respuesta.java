package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class Respuesta {
	
	private Jugador jugador;
	private final ColeccionDeOpciones selecciones;
	public EstadoDeRespuesta estadoDeRespuesta;
	
	public Respuesta(Jugador jugador, int cantidadOpciones) {
		this.jugador = jugador;
		this.selecciones = new ColeccionDeOpciones(cantidadOpciones);
	}
	
	public void agregarOpcionCorrecta(int opcion) {
		this.verificarOpcionValida(opcion);
		this.selecciones.obtener(opcion).definirCorrecta();
	}
	
	private void verificarOpcionValida(int opcion) throws PosicionInvalidaException {
		if( ( opcion < 0 ) || ( opcion > this.selecciones.size() ) ) {
			throw new PosicionInvalidaException();   // TAREAAAAA1"#!2314123!"5RT438Y984IJORT489GU9BROJIRHF98EU
		}
	}
	
	public void calificarMismaRespuesta(ColeccionDeOpciones respuestaCorrecta) {
		/* si las respuesta son iguales suma 1 punto al jugador */
		int i = 1;
		while( i < selecciones.size() ){
			estadoDeRespuesta = selecciones.obtener(i).mismoValor(respuestaCorrecta.obtener(i));
			i++;
		}
		this.jugador.asignarPuntos(estadoDeRespuesta);
	}

}
