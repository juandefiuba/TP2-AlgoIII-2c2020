package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.controlador.ActivarExclusividadHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorDosHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorTresHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.ContadorSegundos;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOk;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Iterator;
import java.util.Timer;

public abstract class ContenedorPregunta extends BorderPane {

    protected Text textoPregunta; //"private final?"
    protected BarraDeMenu menuBar;
    protected HBox botonesBonus;
    protected Kahoot kahoot;
    protected boolean yaRespondioJugador;
    protected Stage stage;
    protected Text timerVisual;
    protected Timer timer;
    protected Button botonOk;
    protected String tipoDePregunta;
    protected Pane contenedorDeOpciones;

    public ContenedorPregunta(Stage stage, HBox botonesBonus, Kahoot kahoot, boolean yaRespondioJugador) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.yaRespondioJugador = yaRespondioJugador;
        this.timerVisual = new Text();
        this.timerVisual.setStyle(" -fx-font-size: 30px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ee0000 ;-fx-stroke-width: 1px");
        this.botonesBonus = botonesBonus;

        this.textoPregunta = ContenedorPregunta.this.getTextoPregunta(kahoot);
        this.botonOk = ContenedorPregunta.this.getBotonOk();
        this.contenedorDeOpciones= this.inicializarContenedorOpciones();
        this.setMenu(stage, botonesBonus);
        stage.sizeToScene();

    }


    public static ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();

        if (pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Clásico", ContenedorPregunta.botonExclusividad(kahoot));


        if (pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot));

        if (pregunta instanceof PreguntaMultipleChoiceClasico) {
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Clásico", ContenedorPregunta.botonExclusividad(kahoot));

        }

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Parcial", ContenedorPregunta.botonExclusividad(kahoot));

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot));

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(stage, kahoot, yaRespondioJugador, "Pregunta Group Choice", ContenedorPregunta.botonExclusividad(kahoot));

        return new ContenedorPreguntaOrderedChoice(stage, kahoot, yaRespondioJugador, "Pregunta Ordered Choice", ContenedorPregunta.botonExclusividad(kahoot));
    }

    abstract protected Pane inicializarContenedorOpciones();

    protected void inicializarContenedorCentral(String rutaFondo, Pos posicion, int spacing) {
        stage.setTitle(tipoDePregunta);
        this.setImagenFondo(kahoot, stage, rutaFondo);

        //CONTENEDOR DE PREGUNTA Y OPCIONES
        VBox contenedorVertical = new VBox();
        contenedorVertical.getChildren().addAll(textoPregunta, contenedorDeOpciones, botonOk);
        contenedorVertical.setAlignment(posicion);
        contenedorVertical.setSpacing(spacing);
        this.setCenter(contenedorVertical);
    }

    public void setImagenFondo (Kahoot kahoot, Stage stage, String rutaArchivoImagen){
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public void setMenu (Stage stage, HBox botonesBonus){
        this.menuBar = new BarraDeMenu(stage);
        botonesBonus.setAlignment(Pos.CENTER_LEFT);
        timerVisual.setTextAlignment(TextAlignment.RIGHT);
        HBox bonusYTimer = new HBox();
        bonusYTimer.setAlignment(Pos.CENTER);
        bonusYTimer.setSpacing(500);
        bonusYTimer.getChildren().addAll(botonesBonus, timerVisual);
        VBox tope = new VBox();
        tope.getChildren().addAll(menuBar, bonusYTimer);
        this.setTop(tope);
    }

    protected Text getTextoPregunta (Kahoot kahoot){
        Text textoPregunta = new Text(kahoot.obtenerPreguntaActual().obtenerTexto());
        textoPregunta.setStyle(" -fx-font-size: 65px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 3px");
        textoPregunta.setWrappingWidth(720);
        textoPregunta.setTextAlignment(TextAlignment.CENTER);
        return textoPregunta;
    }

    protected Button getBotonOk () {
        Button botonOk = new Button("Ok");
        botonOk.setStyle(" -fx-font-size: 2em");
        this.timer = ContadorSegundos.comenzar(botonOk, this.timerVisual, 21);
        botonOk.setOnAction(new BotonOk(kahoot, stage, yaRespondioJugador, this.timer));
        return botonOk;
    }

    //métodos estáticos

    protected static HBox botonesMultiplicadores(Kahoot kahoot) {
        Button multiplicadorX2 = new Button("Multiplicador x2");
        multiplicadorX2.setStyle(" -fx-font-size: 1.5em");
        multiplicadorX2.setOnAction(new MultiplicadorPorDosHandler(kahoot));
        multiplicadorX2.setMinWidth(170);
        Button multiplicadorX3 = new Button("Multiplicador x3");
        multiplicadorX3.setStyle(" -fx-font-size: 1.5em");
        multiplicadorX3.setOnAction(new MultiplicadorPorTresHandler(kahoot));
        multiplicadorX3.setMinWidth(170);
        HBox contenedorConBoton = new HBox();
        contenedorConBoton.getChildren().addAll(multiplicadorX2, multiplicadorX3);
        return contenedorConBoton;
    }

    protected static HBox botonExclusividad (Kahoot kahoot){
        Button exclusividad = new Button("Exclusividad");
        exclusividad.setStyle(" -fx-font-size: 1.5em");
        exclusividad.setOnAction(new ActivarExclusividadHandler(kahoot));
        HBox contenedorConBoton = new HBox();
        contenedorConBoton.getChildren().add(exclusividad);
        return contenedorConBoton;
    }



}
