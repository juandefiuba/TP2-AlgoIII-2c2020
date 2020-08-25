package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.ContadorSegundos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.BotonOkChoice;
import edu.fiuba.algo3.vista.handlers.BotonOkVisualGroupChoice;
import edu.fiuba.algo3.vista.handlers.SeleccionarOpcionGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Timer;

public class ContenedorPreguntaGroupChoice extends ContenedorPregunta {

    public ContenedorPreguntaGroupChoice(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.contenedorCentral();
    }

    @Override
    protected void contenedorCentral() {
        stage.setTitle("Pregunta Ordered Choice" + "| Turno de: " + kahoot.obtenerJugadorActual().getNombreJugador());

        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        Text mensaje = new Text();

        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesGrupo1 = new VBox();
        VBox vboxOpcionesGrupo2 = new VBox();

        Button botonOkInvisible = new Button();
        Timer conteo = ContadorSegundos.ContadorSegundos(botonOkInvisible, timer);
        botonOkInvisible.setOnAction(new BotonOkChoice(kahoot, stage, yaRespondioJugador, conteo));

        Button botonOk = new Button("OK");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOkVisualGroupChoice(kahoot, stage, yaRespondioJugador, vboxOpcionesDadas, mensaje, conteo));

        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox menuInteractivo = new HBox();
        Button botonPasarAGrupo1 = new Button("<-");
        Button botonPasarAGrupo2 = new Button("->");

        menuInteractivo.getChildren().addAll(vboxOpcionesGrupo1, botonPasarAGrupo1, vboxOpcionesDadas, botonPasarAGrupo2, vboxOpcionesGrupo2,botonOk);
        menuInteractivo.setAlignment(Pos.CENTER);
        menuInteractivo.setSpacing(100);
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = (Opcion) iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesGrupo1, vboxOpcionesGrupo2, vboxOpcionesDadas, botonPasarAGrupo1, botonPasarAGrupo2, botonOk);
        }

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, menuInteractivo, mensaje, botonOk);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(50);

        this.setCenter(contenedorVertical);
    }

    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox grupo1, VBox grupo2, VBox grupoDado, Button pasarAGrupo1, Button pasarAGrupo2, Button botonOk){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(250,50);
        botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion, pasarAGrupo1, pasarAGrupo2, grupo1, grupo2, grupoDado, botonOk, opcion, kahoot));
    }
}