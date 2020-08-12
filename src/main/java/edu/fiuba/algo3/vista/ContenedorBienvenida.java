package edu.fiuba.algo3.vista;

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

    Stage stage;

    public ContenedorBienvenida() {

        super();

        this.setAlignment(Pos.CENTER);
        this.setSpacing(700);
        this.setPadding(new Insets(25));
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/kahoot-1.jpg");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Comenzar juego");

        botonEntrar.setStyle("-fx-border-color: Color.black; -fx-border-width: 5px;-fx-background-color: Color.white;-fx-font-size: 2em;-fx-text-fill: Color.black");
        botonEntrar.setMinSize(200,100);
        botonEntrar.setMaxSize(400 , 200);

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Tahoma", FontWeight.BOLD, 40));
        etiqueta.setText("Bienvenid@s a Kahoot");
        etiqueta.setTextFill(Color.BLACK);

        //BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        //botonEntrar.setOnAction(botonEntrarHandler);

        this.getChildren().addAll(etiqueta, botonEntrar);
    }
}
