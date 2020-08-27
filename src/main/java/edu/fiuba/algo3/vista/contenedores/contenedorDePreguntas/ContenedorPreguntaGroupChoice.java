package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.vista.ContadorSegundos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOk;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOkVisualGroupChoice;
import edu.fiuba.algo3.vista.handlers.SeleccionarOpcionGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Timer;

public class ContenedorPreguntaGroupChoice extends ContenedorPregunta {

    public ContenedorPreguntaGroupChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, String tipoDePregunta, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.tipoDePregunta = tipoDePregunta;
        this.inicializarContenedorCentral("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png", Pos.TOP_CENTER, 100);
    }

    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox grupo1, VBox grupo2, VBox grupoDado, Button pasarAGrupo1, Button pasarAGrupo2, Button botonOk){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion, pasarAGrupo1, pasarAGrupo2, grupo1, grupo2, grupoDado, botonOk, opcion, kahoot));
    }

    @Override
    protected Pane inicializarContenedorOpciones() {
        Text mensaje = new Text();
        mensaje.setStyle(" -fx-font-size: 25px ;-fx-font-weight: bold ; -fx-fill: #ff0000;-fx-stroke: #000000 ;-fx-stroke-width: 2px");

        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesGrupo1 = new VBox();
        VBox vboxOpcionesGrupo2 = new VBox();

        Button botonOkInvisible = new Button();
        timer = ContadorSegundos.comenzar(botonOkInvisible, timerVisual, 21);
        botonOkInvisible.setOnAction(new BotonOk(kahoot, stage, yaRespondioJugador, timer));

        Button botonOk = new Button("OK");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOkVisualGroupChoice(kahoot, stage, yaRespondioJugador, vboxOpcionesDadas, mensaje, timer));

        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox menuInteractivo = new HBox();
        Button botonPasarAGrupo1 = new Button("<-");
        Button botonPasarAGrupo2 = new Button("->");

        menuInteractivo.getChildren().addAll(vboxOpcionesGrupo1, botonPasarAGrupo1, vboxOpcionesDadas, botonPasarAGrupo2, vboxOpcionesGrupo2);
        menuInteractivo.setAlignment(Pos.CENTER);
        menuInteractivo.setSpacing(100);
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesGrupo1, vboxOpcionesGrupo2, vboxOpcionesDadas, botonPasarAGrupo1, botonPasarAGrupo2, botonOk);
        }
        VBox opciones = new VBox();
        opciones.getChildren().addAll(menuInteractivo);
        opciones.setAlignment(Pos.CENTER);
        return opciones;
    }
/*
    @Override
    protected void inicializarContenedorCentral(String rutaFondo, Pos Posicion, int spacing) {
        stage.setTitle(tipoDePregunta);
        this.setImagenFondo(kahoot, stage, rutaFondo);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(textoPregunta, contenedorDeOpciones);
        contenedorVertical.setAlignment(Posicion);
        contenedorVertical.setSpacing(spacing);
        this.setCenter(contenedorVertical);
    }*/
}