package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.CambiarDeGrupoYMarcarComoElegida;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Iterator;

public class ContenedorPreguntaOrderedChoice extends ContenedorPregunta {

    public ContenedorPreguntaOrderedChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, String tipoDePregunta, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.tipoDePregunta = tipoDePregunta;
        this.inicializarContenedorCentral("file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png", Pos.TOP_CENTER, 50);
    }


    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox opcionesMarcadas, Button botonOk){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        botonOpcion.setOnAction(new CambiarDeGrupoYMarcarComoElegida(kahoot, botonOpcion, opcion ,opcionesDadas, opcionesMarcadas, botonOk));
    }


    @Override
    protected Pane inicializarContenedorOpciones() {
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesMarcadas = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesMarcadas, botonOk);
        }
        HBox contenedorDeOpciones = new HBox();
        VBox opcionesDadasConTitulo = new VBox();
        VBox opcionesRespuestaConTitulo = new VBox();
        Text tituloDeOpcionesDadas = new Text("Opciones dadas:");
        tituloDeOpcionesDadas.setStyle(" -fx-font-size: 20px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 1px");
        Text tituloDeOpcionesMarcadas = new Text("Respuesta:");
        tituloDeOpcionesMarcadas.setStyle(" -fx-font-size: 20px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 1px");
        opcionesDadasConTitulo.getChildren().addAll(tituloDeOpcionesDadas, vboxOpcionesDadas);
        opcionesRespuestaConTitulo.getChildren().addAll(tituloDeOpcionesMarcadas, vboxOpcionesMarcadas);
        contenedorDeOpciones.getChildren().addAll(opcionesDadasConTitulo, opcionesRespuestaConTitulo);
        contenedorDeOpciones.setAlignment(Pos.CENTER);
        contenedorDeOpciones.setSpacing(20);
        return contenedorDeOpciones;
    }
}