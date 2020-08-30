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

    public ContenedorPreguntaOrderedChoice(double segundos, String tipoDePregunta, Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus, String rutaFondo, boolean seguirCancion) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador, segundos, tipoDePregunta, rutaFondo, seguirCancion);
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
        //Inicializacion
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesMarcadas = new VBox();
        HBox contenedorDeOpciones = new HBox();
        VBox opcionesDadasYSuTitulo = new VBox();
        VBox opcionesRespuestaYSuTitulo = new VBox();

        //Comportamiento
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesMarcadas, botonOk);
        }
        randomizarVBox(vboxOpcionesDadas);

        //Seteo de contenedores
        Text tituloDeOpcionesDadas = new Text("Opciones dadas:");
        tituloDeOpcionesDadas.setStyle(" -fx-font-size: 20px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 1px");
        Text tituloDeOpcionesMarcadas = new Text("Respuesta:");
        tituloDeOpcionesMarcadas.setStyle(" -fx-font-size: 20px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 1px");
        opcionesDadasYSuTitulo.getChildren().addAll(tituloDeOpcionesDadas, vboxOpcionesDadas);
        opcionesRespuestaYSuTitulo.getChildren().addAll(tituloDeOpcionesMarcadas, vboxOpcionesMarcadas);
        contenedorDeOpciones.getChildren().addAll(opcionesDadasYSuTitulo, opcionesRespuestaYSuTitulo);
        contenedorDeOpciones.setAlignment(Pos.CENTER);
        return contenedorDeOpciones;
    }


}