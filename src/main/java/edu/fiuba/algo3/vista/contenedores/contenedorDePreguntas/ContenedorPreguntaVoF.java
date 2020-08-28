package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOkVoF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends ContenedorPregunta {

    public ContenedorPreguntaVoF(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, String tipoDePregunta, HBox botonesBonus, double segundos) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador, segundos);
        this.tipoDePregunta = tipoDePregunta;
        this.inicializarContenedorCentral("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png", Pos.CENTER, 100);
    }



    void agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator<Opcion> iteradorDeOpciones){
        Opcion opcion = iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new BotonOkVoF(kahoot, stage, opcion, botonOpcion, yaRespondioJugador));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
    }


    @Override
    protected Pane inicializarContenedorOpciones() {
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox opcionesHorizontal = new HBox();
        agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
        agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones);
        return opcionesHorizontal;
    }
}