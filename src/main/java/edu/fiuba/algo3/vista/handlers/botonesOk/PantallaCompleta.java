package edu.fiuba.algo3.vista.handlers.botonesOk;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class PantallaCompleta implements EventHandler<ActionEvent> {

	private final Stage stage;
	private boolean yaEstaCompleta;
	private final MenuItem opcion;

	public PantallaCompleta(Stage stage, MenuItem opcion){
		this.stage = stage;
		this.yaEstaCompleta = false;
		this.opcion = opcion;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		if(yaEstaCompleta) {
			stage.setFullScreen(false);
			opcion.setText("Activar pantalla completa");
			yaEstaCompleta = false;
		} else {
			stage.setFullScreen(true);
			opcion.setText("Desactivar pantalla completa");
			yaEstaCompleta = true;
		}
	}
}
