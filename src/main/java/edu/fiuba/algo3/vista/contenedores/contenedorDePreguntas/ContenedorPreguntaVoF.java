package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.ContadorSegundos;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOk;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOkVoF;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Timer;

//variable global spacing y tamaño botones

public class ContenedorPreguntaVoF extends ContenedorPregunta {

    private final String tipoDePregunta;

    public ContenedorPreguntaVoF(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, String tipoDePregunta, HBox botonesBonus) {
        super(stage, botonesBonus, kahoot, yaRespondioJugador);
        this.tipoDePregunta = tipoDePregunta;
        this.contenedorCentral();
    }

    @Override
    protected void contenedorCentral() {
        stage.setTitle("Pregunta Verdadero o Falso " + tipoDePregunta + "| Turno de: " + kahoot.obtenerJugadorActual().getNombreJugador() + " Puntaje: " + kahoot.obtenerJugadorActual().obtenerPuntos());
        //Falta escena en el medio que indique cambio de turno
        String rutaArchivoFondo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/textura.png";
        this.setImagenFondo(kahoot, stage, rutaArchivoFondo);

        Button botonOkInvisible = new Button();
        Timer conteo = ContadorSegundos.ContadorSegundos(botonOkInvisible, timer);
        botonOkInvisible.setOnAction(new BotonOk(kahoot, stage, yaRespondioJugador, conteo));

        //CONTENEDOR DE OPCIONES
        Iterator<Opcion> iteradorDeOpciones = kahoot.obtenerPreguntaActual().obtenerOpciones();
        HBox opcionesHorizontal = new HBox();
        Button botonOpcion1 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, conteo);
        Button botonOpcion2 = agregarBotonOpcion(opcionesHorizontal, kahoot, stage, iteradorDeOpciones, conteo);

        //PREGUNTA (TAMBIÉN BOTÓN)
        Button cajaDePregunta = new Button(kahoot.obtenerPreguntaActual().obtenerTexto());
        cajaDePregunta.setStyle("-fx-border-color: #000000; -fx-border-width: 5px; -fx-background-color: #ffffff; -fx-font-size: 4.5em ;-fx-text-fill: #000000");
        cajaDePregunta.setWrapText(true);
        cajaDePregunta.setTextAlignment(TextAlignment.CENTER);
        cajaDePregunta.setMinSize(500,100);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(cajaDePregunta, opcionesHorizontal);
        contenedorVertical.setAlignment(Pos.CENTER);
        contenedorVertical.setSpacing(100);
        this.setCenter(contenedorVertical);
    }

    Button agregarBotonOpcion(HBox opcionesHorizontal, Kahoot kahoot, Stage stage, Iterator<Opcion> iteradorDeOpciones, Timer conteo){
        Opcion opcion = iteradorDeOpciones.next();
        Button botonOpcion = new Button(opcion.obtenerTexto());
        botonOpcion.setOnAction(new BotonOkVoF(kahoot, stage, opcion, botonOpcion, yaRespondioJugador, conteo));
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion.setMinSize(500,100);
        opcionesHorizontal.getChildren().add(botonOpcion);
        opcionesHorizontal.setAlignment(Pos.CENTER);
        opcionesHorizontal.setSpacing(200);
        return botonOpcion;
    }

}