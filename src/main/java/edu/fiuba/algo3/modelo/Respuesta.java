package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.EstadosDeRespuesta.EstadoDeRespuesta;

public class Respuesta {
	
	private Jugador jugador;
	private final ColeccionDeOpciones selecciones;
	private EstadoDeRespuesta estadoDeRespuesta;
	
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
			throw new PosicionInvalidaException();   // TAREA: ver como tratar los errores, por ahora no toque nada de errores
		}
	}
	
	public void calificarMismaRespuesta(ColeccionDeOpciones respuestaCorrecta) {
		/* si las respuesta son iguales suma 1 punto al jugador */
		estadoDeRespuesta = selecciones.calificarRespuestaDelJugador(respuestaCorrecta);
		this.jugador.asignarPuntos(estadoDeRespuesta);
	}

}
