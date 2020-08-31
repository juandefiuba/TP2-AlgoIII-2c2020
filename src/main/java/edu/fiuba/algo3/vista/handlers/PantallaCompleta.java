package edu.fiuba.algo3.vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PantallaCompleta implements EventHandler<ActionEvent> {

	private final Stage stage;
	private final MenuItem opcion;

	public PantallaCompleta(Stage stage, MenuItem opcion){
		this.stage = stage;
		this.opcion = opcion;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		if(stage.isMaximized()) {
			stage.setMaximized(false);
			stage.setMaximized(true);
			stage.setMaximized(false);
			opcion.setText("Activar pantalla completa");
		} else {
			stage.setMaximized(true);
			opcion.setText("Desactivar pantalla completa");
		}
	}
}
