package edu.fiuba.algo3.vista.contenedores;


import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonParaIngresarNombre;
import edu.fiuba.algo3.vista.handlers.TextoEventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class ContenedorInicio extends BorderPane {

    private BarraDeMenu menuBar;

    //CONTENEDOR PRINCIPAL
    public ContenedorInicio(Stage stage, Kahoot kahoot) {
        this.setMenu(stage);
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {

        //FONDO
        String rutaArchivoImagen = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //ETIQUETA
        Label titulo = new Label("Ingrese nombre del jugador:");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 55));

        //ENTRADA DE TEXTO
        TextField textField = new TextField();
        textField.setPromptText("Nombre");
        textField.setStyle("-fx-font-size:55");
        textField.setAlignment(Pos.CENTER);
        textField.setMaxWidth(660);

        //BOTÓN
        String estiloBoton = "-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000";
        Button botonOk = new Button("Ok");
        botonOk.setStyle(estiloBoton);
        botonOk.setMinSize(200,100);
        botonOk.setOnAction(new BotonParaIngresarNombre(textField, stage, kahoot));

        textField.setOnKeyPressed(new TextoEventHandler(botonOk));

        //CONTENEDOR DE TEXTO, ENTRADA Y BOTÓN
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(titulo, textField, botonOk);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setAlignment(Pos.CENTER);

        this.setCenter(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
}