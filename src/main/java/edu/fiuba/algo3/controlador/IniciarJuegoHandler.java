package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class IniciarJuegoHandler implements EventHandler<ActionEvent> {

	private Kahoot kahoot;

	public IniciarJuegoHandler(Kahoot kahoot) {
		this.kahoot = kahoot;
	}
	
	@Override
	public void handle(ActionEvent event) {
		kahoot.iniciarJuego();
	}

}
