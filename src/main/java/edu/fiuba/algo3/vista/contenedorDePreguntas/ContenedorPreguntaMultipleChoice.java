package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.BotonOkMultipleChoice;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionMultipleChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaMultipleChoice extends ContenedorPregunta {

    BarraDeMenu menuBar;
    Kahoot kahoot;
    boolean yaRespondioJugador;

    public ContenedorPreguntaMultipleChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        this.setMenu(stage);
        this.yaRespondioJugador = yaRespondioJugador;
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {
        this.imprimirNombreYPuntaje(kahoot, stage);
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        //BOTONES
        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox contenedorOpciones = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            HBox opcionesHorizontal = new HBox();
            agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
            if (iteradorDeOpciones.hasNext()){
                agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
            }
            contenedorOpciones.getChildren().add(opcionesHorizontal);
        }
        String nombreJugador = kahoot.obtenerJugadorActual().getNombreJugador();
        int puntaje= kahoot.obtenerJugadorActual().obtenerPuntos();
        stage.setTitle("Pregunta MultipleChoice - Turno de " + nombreJugador + ". Puntaje: " + puntaje);

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        Button botonOk = new Button("OK");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOkMultipleChoice(kahoot, stage, yaRespondioJugador));

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, contenedorOpciones, botonOk);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(80);

        this.setCenter(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    void agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator iteradorDeOpciones){
        Opcion opcion = (Opcion) iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new MarcarOpcionMultipleChoice(kahoot, opcion, botonOpcion));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(500,100);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
    }
}