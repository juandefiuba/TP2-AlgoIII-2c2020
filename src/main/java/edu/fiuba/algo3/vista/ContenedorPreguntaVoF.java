package edu.fiuba.algo3.vista;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends BorderPane {

    BarraDeMenu menuBar;

    public ContenedorPreguntaVoF(Stage stage) {
        this.setMenu(stage);
        this.contenedorCentral(stage);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage) {

        //FONDO
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        Image imagen = new Image(rutaArchivoFondo);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //BOTONES
        Button botonVerdadero = new Button("Verdadero");
        botonVerdadero.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #40CD24");
        botonVerdadero.setMinSize(500,100);

        Button botonFalso = new Button("Falso");
        botonFalso.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #CD2433");
        botonFalso.setMinSize(500,100);

        //CONTENEDOR DE OPCIONES
        HBox opciones = new HBox();
        opciones.getChildren().addAll(botonVerdadero, botonFalso);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(200);

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button("El Monte Everest es la montaña más alta del mundo");
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opciones);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(200);

        this.setCenter(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

}