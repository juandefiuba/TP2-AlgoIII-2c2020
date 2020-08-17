package edu.fiuba.algo3.controlador;

import java.util.LinkedList;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorDeTurnos implements EventHandler<ActionEvent> {
	
	private Pregunta pregunta;
	private Jugador jugador;
	private LinkedList<Opcion> respuesta;

	public ManejadorDeTurnos(Pregunta pregunta, Jugador jugador, LinkedList<Opcion> respuesta) {
		this.pregunta = pregunta;
		this.jugador = jugador;
		this.respuesta = respuesta;
	}
	
	@Override
	public void handle(ActionEvent event) {
		pregunta.agregarRespuestaDeJugador(this.jugador, this.respuesta);
		// TODO: cambiar escena?
	}

}
