package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Utilidades;
import edu.fiuba.algo3.vista.handlers.BotonOkVoF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends ContenedorPregunta {

    BarraDeMenu menuBar;
    boolean yaRespondioJugador;

    public ContenedorPreguntaVoF(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        Utilidades utilidades = new Utilidades();
        this.setMenu(stage, utilidades);
        this.yaRespondioJugador = yaRespondioJugador;
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {
        this.imprimirNombreYPuntaje(kahoot, stage);
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        //CONTENEDOR DE OPCIONES
        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox opcionesHorizontal = new HBox();
        Button botonOpcion1 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
        Button botonOpcion2 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);

        String nombreJugador = kahoot.obtenerJugadorActual().getNombreJugador();
        int puntaje= kahoot.obtenerJugadorActual().obtenerPuntos();
        stage.setTitle("Pregunta MultipleChoice - Turno de " + nombreJugador + ". Puntaje: " + puntaje);

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opcionesHorizontal);
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
        botonOpcion.setOnAction(new BotonOkVoF(kahoot, stage, opcion, botonOpcion, yaRespondioJugador));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(500,100);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
        return botonOpcion;
    }

}