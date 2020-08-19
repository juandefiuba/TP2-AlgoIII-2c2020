package edu.fiuba.algo3.controlador;

import java.util.LinkedList;

import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.Pregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class AvanzarTurnoDeJugadorHandler implements EventHandler<ActionEvent> {
	
	private Kahoot kahoot;

	public AvanzarTurnoDeJugadorHandler(Kahoot kahoot) {
		this.kahoot = kahoot;
	}
	
	@Override
	public void handle(ActionEvent event) {
		kahoot.avanzarAProximoJugador();
	}

}
