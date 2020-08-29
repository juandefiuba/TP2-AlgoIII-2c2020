package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.controlador.IniciarJuegoHandler;
import edu.fiuba.algo3.controlador.NuevoJugadorHandler;
import edu.fiuba.algo3.modelo.Jugador;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedores.ContenedorPaseDePantalla;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.LinkedList;

public class BotonParaIngresarNombre implements EventHandler<ActionEvent> {

	private final TextField texto;
	private final Stage stage;
	private final Kahoot kahoot;
	private final Text mensajeInput;
	private String nombrePrimerJugador;
	private boolean yaIngresaronUnNombre;

	public BotonParaIngresarNombre(TextField texto, Stage stage, Kahoot kahoot, Text mensajeInput){
		this.texto = texto;
		this.stage = stage;
		this.kahoot = kahoot;
		this.yaIngresaronUnNombre = false;
		this.nombrePrimerJugador = "";
		this.mensajeInput = mensajeInput;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		String nombreJugador = texto.getText();
		if (nombreJugador.isEmpty()) {
			mensajeInput.setText("Por favor ingrese un nombre");
			return;
		}
		if(nombreJugador.equals(nombrePrimerJugador)){
			mensajeInput.setText("Jugador ya ingresado");
			return;
		}

		new NuevoJugadorHandler(kahoot, nombreJugador).handle(actionEvent);
		nombrePrimerJugador = nombreJugador;
		texto.clear();
		texto.requestFocus();
		mensajeInput.setText("");
		if (yaIngresaronUnNombre) {
			new IniciarJuegoHandler(kahoot).handle(actionEvent);
			BorderPane contenedorTurnoDe = new ContenedorPaseDePantalla(kahoot, stage, false);
			Scene escenaPregunta = new Scene(contenedorTurnoDe, stage.getWidth(), stage.getHeight());
			stage.setScene(escenaPregunta);
		}
		yaIngresaronUnNombre = true;
	}
}
