package edu.fiuba.algo3.vista;

import edu.fiuba.algo3.controlador.ManejadorDeSalida;
import edu.fiuba.algo3.vista.handlers.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorBienvenida extends VBox {

    Stage stage;

    public ContenedorBienvenida(Scene proximaEscena, Stage stage) {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(600);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahoot-1.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Iniciar");
        Button botonSalir = new Button();
        botonSalir.setText("Salir");

        botonEntrar.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000");
        botonEntrar.setMinSize(200,100);
        botonEntrar.setMaxSize(400 , 200);
        botonSalir.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000");
        botonSalir.setMinSize(200,100);
        botonSalir.setMaxSize(400 , 200);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 60));
        etiqueta.setText("Bienvenid@s a");
        etiqueta.setTextFill(Color.BLACK);


        HBox contenedorHorizontal = new HBox();
        contenedorHorizontal.setSpacing(250);
        contenedorHorizontal.getChildren().addAll(botonEntrar, botonSalir);
        contenedorHorizontal.setAlignment(Pos.CENTER);
        this.getChildren().addAll(etiqueta, contenedorHorizontal);

        botonSalir.setOnAction(new ManejadorDeSalida());
        botonEntrar.setOnAction(new BotonEntrarEventHandler(stage, proximaEscena));
    }
}
