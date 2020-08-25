package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.controlador.IniciarJuegoHandler;
import edu.fiuba.algo3.controlador.NuevoJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedores.ContenedorPaseDePantalla;
import edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BotonParaIngresarNombre implements EventHandler<ActionEvent> {

	private final TextField texto;
	private final Stage stage;
	private final Kahoot kahoot;
	private boolean yaIngresaronUnNombre;

	public BotonParaIngresarNombre(TextField texto, Stage stage, Kahoot kahoot){
		this.texto = texto;
		this.stage = stage;
		this.kahoot = kahoot;
		this.yaIngresaronUnNombre = false;
	}

	@Override
	public void handle(ActionEvent actionEvent) {
		new NuevoJugadorHandler(kahoot, texto.getText()).handle(actionEvent);
		texto.clear();
		texto.requestFocus();
		if (yaIngresaronUnNombre) {
			new IniciarJuegoHandler(kahoot).handle(actionEvent);
			ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, false);
			BorderPane contenedorTurnoDe = new ContenedorPaseDePantalla(kahoot, stage, contenedorPregunta);
			Scene escenaPregunta = new Scene(contenedorTurnoDe, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
			stage.sizeToScene();
			stage.setScene(escenaPregunta);
		}
		yaIngresaronUnNombre = true;
	}

}
