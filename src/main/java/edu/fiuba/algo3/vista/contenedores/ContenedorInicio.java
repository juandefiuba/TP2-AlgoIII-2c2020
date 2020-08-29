package edu.fiuba.algo3.vista.contenedores;


import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.CambiadorImagenFondoEntreTurnos;
import edu.fiuba.algo3.vista.handlers.TextoEventHandler;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonParaIngresarNombre;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
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
        Image imagen = new Image(CambiadorImagenFondoEntreTurnos.getRutaFondo());
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //ETIQUETA
        Text titulo = new Text("Ingrese nombre del jugador:");
        titulo.setStyle(" -fx-font-size: 75px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 4px");
        titulo.setWrappingWidth(stage.getWidth());
        titulo.setTextAlignment(TextAlignment.CENTER);
        Text mensajeInput = new Text();
        mensajeInput.setStyle(" -fx-font-size: 50px ;-fx-font-weight: bold ; -fx-fill: #ff0000;-fx-stroke: #000000 ;-fx-stroke-width: 2px");

        //ENTRADA DE TEXTO
        TextField textField = new TextField();
        textField.setPromptText("Nombre");
        textField.setStyle("-fx-font-size:55");
        textField.setAlignment(Pos.CENTER);
        textField.setMaxWidth(660);

        //BOTÓN
        String estiloBoton = "-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 2em ;-fx-text-fill: #000000";
        Button botonOk = new Button("Ok");
        botonOk.setStyle(estiloBoton);
        botonOk.setMinSize(150,75);
        botonOk.setOnAction(new BotonParaIngresarNombre(textField, stage, kahoot, mensajeInput, this));

        textField.setOnKeyPressed(new TextoEventHandler(botonOk));

        //CONTENEDOR DE TEXTO, ENTRADA Y BOTÓN
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(titulo, textField, mensajeInput, botonOk);
        contenedorVertical.setAlignment(Pos.CENTER);

        VBox contenedorTitulo = new VBox(titulo);
        contenedorTitulo.setAlignment(Pos.CENTER);
        VBox contenedorBoton = new VBox(botonOk);
        contenedorBoton.setAlignment(Pos.CENTER);
        VBox contenedorCentro = new VBox(textField, mensajeInput);
        contenedorCentro.setAlignment(Pos.CENTER);
        this.setTop(contenedorTitulo);
        this.setCenter(contenedorCentro);
        this.setBottom(contenedorBoton);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
}