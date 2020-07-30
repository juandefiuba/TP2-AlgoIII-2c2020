package edu.fiuba.algo3.modelo;


public class Respuesta {
	
	private Jugador jugador;
	private ColeccionDeOpciones selecciones;
	
	public Respuesta(Jugador jugador, int cantidadOpciones) {
		// me gustaria buscar una manera de que solo la clase Pregunta pueda llamar este constructor
		this.jugador = jugador;
		this.selecciones = new ColeccionDeOpciones(cantidadOpciones);
	}
	
	/* tira excepcion si la opcion es invalida (ej opcion -1) */
	public void agregarOpcionElegida(Integer opcion) {
		this.selecciones.tildarOpcion(opcion);
	}
	
	public void calificarRespuestaClasica(ColeccionDeOpciones respuestaCorrecta) {
		/* si las respuesta son iguales suma 1 punto al jugador */
		Boolean iguales = true;
		int i = 1;
		while( (i <= this.selecciones.size() ) && (iguales) ) {
			iguales = this.selecciones.get(i).mismoValor(respuestaCorrecta.get(i));
			i++;
		}
		if(iguales) {
			this.jugador.asignarPuntos( new Puntaje(1) );
		}
	}
	
	public void calificarRespuestaConPenalidad(ColeccionDeOpciones respuestaCorrecta) {
		Integer puntos = 0;
		int i = 1;
		while ( i <= this.selecciones.size() ) {
			Opcion opcionCorrecta = respuestaCorrecta.get(i);
			Opcion opcionElegida = this.selecciones.get(i);
			puntos += opcionCorrecta.puntuarOpcion(opcionElegida);
			i++;
		}
		this.jugador.asignarPuntos( new Puntaje(puntos) );
	}
	
	public void calificarRespuestaParcial(ColeccionDeOpciones respuestaCorrecta) {
		Boolean error = false;
		Integer puntos = 0;
		Integer puntosASumar;
		int i = 1;
		while ( ( i <= this.selecciones.size() ) && (!error)) {
			Opcion opcionCorrecta = respuestaCorrecta.get(i);
			Opcion opcionElegida = this.selecciones.get(i);
			puntosASumar = opcionCorrecta.puntuarOpcion(opcionElegida);
			error = (puntosASumar == -1); /* jugador elegió una opcion incorrecta como correcta */
			puntos += puntosASumar;
			i++;
		}
		if(!error) {
			this.jugador.asignarPuntos( new Puntaje(puntos) );
		}
		
	}

}
