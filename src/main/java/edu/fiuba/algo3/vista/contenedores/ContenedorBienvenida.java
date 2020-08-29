package edu.fiuba.algo3.vista.contenedores;


import edu.fiuba.algo3.controlador.SalirDelJuegoHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonEntrarEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox {

	public ContenedorBienvenida(Stage stage, Kahoot kahoot) {
		String rutaArchivoImagenFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahoot-1.png";
		String estiloBoton = "-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000";

		//IMAGEN DE FONDO
		Image imagen = new Image(rutaArchivoImagenFondo);
		BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		this.setBackground(new Background(imagenDeFondo));

		//BOTONES
		Button botonEntrar = new Button("Iniciar");
		botonEntrar.setStyle(estiloBoton);
		botonEntrar.setMinSize(200,100);
		Button botonSalir = new Button("Salir");
		botonSalir.setStyle(estiloBoton);
		botonSalir.setMinSize(200,100);

		//TEXTO DE BIENVENIDA
		Label etiqueta = new Label("Bienvenid@s a");
		etiqueta.setStyle(" -fx-font-size: 75px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 4px");
		etiqueta.setTextAlignment(TextAlignment.CENTER);

		//CONTENEDOR DE BOTONES
		HBox contenedorBotones = new HBox();
		contenedorBotones.setAlignment(Pos.CENTER);
		contenedorBotones.getChildren().addAll(botonEntrar, botonSalir);
		contenedorBotones.setSpacing(50);

		//CONTENEDOR PRINCIPAL
		Pane filler = new Pane();
		VBox.setVgrow(filler, Priority.ALWAYS);
		this.setAlignment(Pos.CENTER);
		this.getChildren().addAll(etiqueta, filler, contenedorBotones);

		//LLAMADA A MANEJADORES
		botonSalir.setOnAction(new SalirDelJuegoHandler());
		botonEntrar.setOnAction(new BotonEntrarEventHandler(stage, kahoot));
	}
}