package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.handlers.SeleccionarOpcionGroupChoice;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;

public class ContenedorPreguntaGroupChoice extends ContenedorPregunta {

    BarraDeMenu menuBar;
    Kahoot kahoot;

    public ContenedorPreguntaGroupChoice(Stage stage, Kahoot kahoot) {
        this.setMenu(stage);
        this.contenedorCentral(stage, kahoot);
        stage.sizeToScene();
    }

    private void contenedorCentral(Stage stage, Kahoot kahoot) {

        //FONDO
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        Image imagen = new Image(rutaArchivoFondo);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Iterator iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox menuInteractivo = new HBox();
        Button botonPasarAGrupo1 = new Button("<-");
        Button botonPasarAGrupo2 = new Button("->");
        //botonPasarAGrupo1.setOnAction(new cambiarBotonDeContenedor());
        VBox vboxOpcionesDadas = new VBox();
        VBox vboxOpcionesGrupo1 = new VBox();
        VBox vboxOpcionesGrupo2 = new VBox();
        menuInteractivo.getChildren().addAll(vboxOpcionesGrupo1, botonPasarAGrupo1, vboxOpcionesDadas, botonPasarAGrupo2, vboxOpcionesGrupo2);
        menuInteractivo.setAlignment(Pos.CENTER);
        menuInteractivo.setSpacing(100);
        while (iteradorDeOpciones.hasNext()) {
            Opcion opcion = (Opcion) iteradorDeOpciones.next();
            agregarBotonOpcion(stage, opcion, vboxOpcionesDadas, vboxOpcionesGrupo1, vboxOpcionesGrupo2, botonPasarAGrupo1, botonPasarAGrupo2);
        }

        /*menuInteractivo.getChildren().addAll(vboxOpcionesGrupo1, vboxOpcionesDadas, vboxOpcionesGrupo2);
        menuInteractivo.setAlignment(Pos.CENTER);
        menuInteractivo.setSpacing(200);*/

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);


        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, menuInteractivo);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);

        this.setCenter(contenedorVertical);
    }

    private void setMenu(Stage stage) {
        this.menuBar = new BarraDeMenu(stage);
        this.setTop(menuBar);
    }

    void agregarBotonOpcion(Stage stage, Opcion opcion, VBox opcionesDadas, VBox grupo1, VBox grupo2, Button pasarAGrupo1, Button pasarAGrupo2){
        Button botonOpcion = new Button(opcion.obtenerTexto());
        opcionesDadas.getChildren().add(botonOpcion);
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(100,50);
        botonOpcion.setOnAction(new SeleccionarOpcionGroupChoice(botonOpcion, pasarAGrupo1, pasarAGrupo2, grupo1, grupo2, opcionesDadas));
        //new cambiarBotonDeContenedor(botonOpcion, opcionesDadas, opcionesMarcadas)
    }
}