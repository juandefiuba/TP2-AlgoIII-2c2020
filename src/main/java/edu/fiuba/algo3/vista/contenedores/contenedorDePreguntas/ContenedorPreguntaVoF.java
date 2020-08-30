package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOkVoF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Iterator;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends ContenedorPregunta {

    public ContenedorPreguntaVoF(double segundos, String tipoDePregunta, Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus, String rutaFondo, boolean seguirCancion) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador, segundos, tipoDePregunta, rutaFondo, seguirCancion);
    }

    @Override
    protected void setAbajo() {
        botonesBonus.setAlignment(Pos.BOTTOM_LEFT);
        VBox boxDeAbajo = new VBox(botonOk, botonesBonus);
        boxDeAbajo.setAlignment(Pos.CENTER);
        this.setBottom(boxDeAbajo);
    }

    void agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator<Opcion> iteradorDeOpciones, String colorDeBoton){
        Opcion opcion = iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new BotonOkVoF(kahoot, stage, opcion, botonOpcion, yaRespondioUnJugador));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: "+colorDeBoton);
        botonOpcion.setMinSize(250,50);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
    }


    @Override
    protected Pane inicializarContenedorOpciones() {
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox opcionesHorizontal = new HBox();
        agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, "#008000");
        agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, "#FF0000");
        opcionesHorizontal.setSpacing(100);
        return opcionesHorizontal;
    }
}