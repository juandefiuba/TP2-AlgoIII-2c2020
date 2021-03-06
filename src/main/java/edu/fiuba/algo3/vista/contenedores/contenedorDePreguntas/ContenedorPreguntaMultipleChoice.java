package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.MarcarOpcionMultipleChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaMultipleChoice extends ContenedorPregunta {

    public ContenedorPreguntaMultipleChoice(double segundos, String tipoDePregunta, Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus, String rutaFondo) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador, segundos, tipoDePregunta, rutaFondo);
    }


    private void agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator<Opcion> iteradorDeOpciones, Button botonOk){
        Opcion opcion = iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new MarcarOpcionMultipleChoice(kahoot, opcion, botonOpcion, botonOk));
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
    }

    @Override
    protected Pane inicializarContenedorOpciones() {
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpcionesDesordenadas();
        VBox contenedorOpciones = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            HBox opcionesHorizontal = new HBox();
            agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, botonOk);
            if (iteradorDeOpciones.hasNext()){
                agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, botonOk);
            }
            contenedorOpciones.getChildren().add(opcionesHorizontal);
        }
        return contenedorOpciones;
    }
}