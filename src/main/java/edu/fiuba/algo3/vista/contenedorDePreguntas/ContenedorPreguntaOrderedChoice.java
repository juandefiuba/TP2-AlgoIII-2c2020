package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.ContadorSegundos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.BotonCambiarDeGrupoYMarcarComoElegida;
import edu.fiuba.algo3.vista.handlers.BotonOk;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

public class ContenedorPreguntaOrderedChoice extends ContenedorPregunta {

    public ContenedorPreguntaOrderedChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.contenedorCentral();
    }

    @Override
    protected void contenedorCentral() {
        stage.setTitle("Pregunta Ordered Choice" + "| Turno de: " + kahoot.obtenerJugadorActual().getNombreJugador());

        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        //BOTONES
        Button botonOk = new Button("OK");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOk(kahoot, stage, yaRespondioJugador, ContadorSegundos.ContadorSegundos(botonOk, timer)));

        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesMarcadas = new VBox();
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesMarcadas, botonOk);
        }

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        HBox opciones = new HBox();
        VBox opcionesDadasConTitulo = new VBox();
        VBox opcionesRespuestaConTitulo = new VBox();
        Text tituloDeOpcionesDadas = new Text("Opciones dadas:");
        Text tituloDeOpcionesMarcadas = new Text("Respuesta:");
        opcionesDadasConTitulo.getChildren().addAll(tituloDeOpcionesDadas, vboxOpcionesDadas);
        opcionesRespuestaConTitulo.getChildren().addAll(tituloDeOpcionesMarcadas, vboxOpcionesMarcadas);
        opciones.getChildren().addAll(opcionesDadasConTitulo, opcionesRespuestaConTitulo);
        opciones.setAlignment(Pos.CENTER);
        opciones.setSpacing(20);


        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opciones, botonOk);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(75);

        this.setCenter(contenedorVertical);
    }

    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox opcionesMarcadas, Button botonOk){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        botonOpcion.setOnAction(new BotonCambiarDeGrupoYMarcarComoElegida(kahoot, botonOpcion, opcion ,opcionesDadas, opcionesMarcadas, botonOk));
    }
}