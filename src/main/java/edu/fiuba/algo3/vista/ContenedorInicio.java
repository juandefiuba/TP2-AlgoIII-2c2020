package edu.fiuba.algo3.vista;


import edu.fiuba.algo3.vista.handlers.BotonParaIngresarNombre;
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
    //Canvas canvasCentral;
    //VBox contenedorCentral;

    public ContenedorInicio(Stage stage) {
        this.setMenu(stage);
        this.contenedorCentral(stage);
    }

    private void contenedorCentral(Stage stage) {
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Label titulo = new Label("Ingrese nombre del jugador:");
        titulo.setFont(Font.font("Tahoma", FontWeight.BOLD, 55));

        TextField textField = new TextField();
        textField.setPromptText("Nombre");
        textField.setStyle("-fx-font-size:55");
        textField.setAlignment(Pos.CENTER);
        textField.setMaxWidth(660);
        //textField.getText();

        Button botonEntrar = new Button("Ok");
        botonEntrar.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #FFFFFF; -fx-font-size: 3em ;-fx-text-fill: #000000");
        botonEntrar.setMinSize(200,100);
        botonEntrar.setOnAction(new BotonParaIngresarNombre(textField, stage));

        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(titulo, textField, botonEntrar);
        contenedorVertical.setSpacing(20);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setFocusTraversable(true);

        this.setCenter(contenedorVertical);
    }


    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }
}