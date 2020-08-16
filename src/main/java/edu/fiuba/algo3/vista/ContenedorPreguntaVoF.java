package edu.fiuba.algo3.vista;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends BorderPane {

    BarraDeMenu menuBar;
    Canvas canvasCentral;
    VBox contenedorCentral;

    public ContenedorPreguntaVoF(Stage stage) {
        this.setMenu(stage);
        this.contenedorCentral(stage);
    }

    private void contenedorCentral(Stage stage) {
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonVerdadero = new Button("Verdadero");
        Button botonFalso = new Button("Falso");
        botonVerdadero.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonVerdadero.setMinSize(500,100);
        botonFalso.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonFalso.setMinSize(500,100);

        //botonEntrar.setOnAction(new BotonParaIngresarNombre(textField, stage));

        HBox opciones = new HBox();
        opciones.getChildren().addAll(botonVerdadero, botonFalso);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(200);


        Button cajaDePregunta = new Button("El monte everest es la montaña más alta del mundo");
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);

        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opciones);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setPadding(new Insets(200));
        contenedorVertical.setSpacing(200);

        this.setCenter(contenedorVertical);
    }


    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

}