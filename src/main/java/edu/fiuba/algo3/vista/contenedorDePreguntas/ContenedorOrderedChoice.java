package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.controlador._AgregarRespuestaIndividualHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionEnOrden;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionesElegidasMultipleChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

public class ContenedorOrderedChoice extends ContenedorPregunta {

    BarraDeMenu menuBar;
    Kahoot kahoot;

    public ContenedorOrderedChoice(Stage stage, Kahoot kahoot) {
        this.setMenu(stage);
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {

        //FONDO
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        Image imagen = new Image(rutaArchivoFondo);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        //BOTONES
        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox opcionesDadas = new VBox();
        VBox opcionesMarcadas = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            agregarBotonOpcion(contenedorOpciones, kahoot, stage, iteradorDeOpciones);
        }

        HBox opciones = new HBox();
        opciones.getChildren().addAll(opcionesDadas, opcionesMarcadas);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(300);

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);


        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opciones);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);

        this.setCenter(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    void agregarBotonOpcion(VBox opcionesVertical, Kahoot kahoot, Stage stage, Iterator iteradorDeOpciones){
        Opcion opcion = (Opcion) iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new MarcarOpcionEnOrden(botonOpcion, opcionesDadas, opcionesMarcadas);
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(500,100);
        opcionesVertical.getChildren().add(botonOpcion);
        opcionesVertical.setAlignment(Pos.CENTER);
        opcionesVertical.setSpacing(50);
    }
}