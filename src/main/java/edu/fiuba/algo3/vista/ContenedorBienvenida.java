package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.controlador.SalirDelJuegoHandler;
import edu.fiuba.algo3.vista.handlers.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox {

    public ContenedorBienvenida(Stage stage) {
        super();

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
        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        etiqueta.setText("Bienvenid@s a");
        etiqueta.setTextFill(Color.BLACK);

        //CONTENEDOR DE BOTONES
        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(250);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        contenedorHorizontal.getChildren().addAll(botonEntrar, botonSalir);

        //CONTENEDOR PRINCIPAL
        this.setAlignment(Pos.CENTER);
        this.setSpacing(300);
        this.getChildren().addAll(etiqueta, contenedorHorizontal);

        //LLAMADA A MANEJADORES
        botonSalir.setOnAction(new SalirDelJuegoHandler());
        botonEntrar.setOnAction(new BotonEntrarEventHandler(stage));
    }
}
