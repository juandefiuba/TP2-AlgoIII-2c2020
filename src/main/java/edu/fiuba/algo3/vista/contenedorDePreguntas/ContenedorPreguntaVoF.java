package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Utilidades;
import edu.fiuba.algo3.vista.handlers.BotonOkVoF;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionVoF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends ContenedorPregunta {

    BarraDeMenu menuBar;

    public ContenedorPreguntaVoF(Stage stage, Kahoot kahoot) {
        Utilidades utilidades = new Utilidades();
        this.setMenu(stage, utilidades);
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {

        //FONDO
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        Image imagen = new Image(rutaArchivoFondo);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //CONTENEDOR DE OPCIONES
        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox opcionesHorizontal = new HBox();
        Button botonOpcion1 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
        Button botonOpcion2 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
        Button botonOk = new Button("OK");
        botonOk.setOnAction(new BotonOkVoF(kahoot, stage, botonOpcion1, botonOpcion2));
        botonOk.setStyle(" -fx-font-size: 2em");

        stage.setTitle("Pregunta Verdadero o Falso - Turno de " + "Jugador");

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opcionesHorizontal, botonOk);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);


        this.setCenter(contenedorVertical);
    }



    private void setMenu(Stage stage, Utilidades utilidades) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
        this.setBottom(utilidades);
    }


    Button agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator iteradorDeOpciones){
        Opcion opcion = (Opcion) iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new MarcarOpcionVoF(opcion, kahoot, botonOpcion));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(500,100);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
        return botonOpcion;
    }

}