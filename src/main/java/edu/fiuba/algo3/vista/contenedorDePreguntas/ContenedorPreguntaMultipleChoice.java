package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.ContadorSegundos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.BotonOkChoice;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionMultipleChoice;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Timer;

//variable global spacing y tamaño botones

public class ContenedorPreguntaMultipleChoice extends ContenedorPregunta {

    private final String tipoDePregunta;

    public ContenedorPreguntaMultipleChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, String tipoDePregunta, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.tipoDePregunta = tipoDePregunta;
        this.contenedorCentral();
    }

    @Override
    protected void contenedorCentral() {
        stage.setTitle("Pregunta Multiple Choice " + tipoDePregunta + "| Turno de: " + kahoot.obtenerJugadorActual().getNombreJugador());

        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        //BOTONES
        Button botonOk = new Button("OK");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOkChoice(kahoot, stage, yaRespondioJugador, ContadorSegundos.ContadorSegundos(botonOk, timer)));

        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox contenedorOpciones = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            HBox opcionesHorizontal = new HBox();
            agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, botonOk);
            if (iteradorDeOpciones.hasNext()){
                agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, botonOk);
            }
            contenedorOpciones.getChildren().add(opcionesHorizontal);
        }

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, contenedorOpciones, botonOk);
        contenedorVertical.setAlignment(Pos.TOP_CENTER);
        contenedorVertical.setSpacing(50);

        this.setCenter(contenedorVertical);
    }

    void agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator iteradorDeOpciones, Button botonOk){
        Opcion opcion = (Opcion) iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new MarcarOpcionMultipleChoice(kahoot, opcion, botonOpcion, botonOk));
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
    }
}