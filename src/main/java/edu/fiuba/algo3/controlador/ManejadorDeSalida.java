package edu.fiuba.algo3.controlador;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class ManejadorDeSalida implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.exit(0);
	}

}
