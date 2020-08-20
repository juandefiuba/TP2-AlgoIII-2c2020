package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BotonParaIngresarNombre implements EventHandler<ActionEvent> {

	private TextField texto;
	Stage stage;
	Kahoot kahoot;
	int contador;

	public BotonParaIngresarNombre(TextField texto, Stage stage, Kahoot kahoot){
		this.texto = texto;
		this.stage = stage;
		this.kahoot = kahoot;
		this.contador = 0;
	}
	//Recibir el nombre
	//Mandar a Kahoot el nombre
	//Limpiar la caja de texto
	//Recibir el nombre
	//Mandar a Kahoot el nombre
	//Ir al contenedor de la pregunta

	@Override
	public void handle(ActionEvent actionEvent) {
		contador ++;
		kahoot.agregarJugador(texto.getText());
		texto.clear();
		if (contador == 2) {
			kahoot.iniciarJuego();
			ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot);
			Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
			stage.sizeToScene();
			stage.setScene(escenaPregunta);
		}
	}

}
