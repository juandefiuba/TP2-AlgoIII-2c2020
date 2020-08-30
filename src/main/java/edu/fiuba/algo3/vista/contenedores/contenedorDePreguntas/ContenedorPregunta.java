package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.controlador.ActivarExclusividadHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorDosHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorTresHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.Musica;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.handlers.ResetearOpcionesElegidas;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOk;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public abstract class ContenedorPregunta extends BorderPane {

    protected boolean seguirCancion;
    protected Text textoPregunta;
    protected BarraDeMenu menuBar;
    protected HBox botonesBonus;
    protected Kahoot kahoot;
    protected boolean yaRespondioUnJugador;
    protected Stage stage;
    protected Text timerVisual;
    protected Button botonOk;
    protected String tipoDePregunta;
    protected double segundos;

    public ContenedorPregunta(Stage stage, HBox botonesBonus, Kahoot kahoot, boolean yaRespondioUnJugador, double segundos, String tipoDePregunta, String rutaFondo, boolean seguirCancion) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.tipoDePregunta = tipoDePregunta;
        this.segundos = segundos;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.timerVisual = new Text();
        this.timerVisual.setStyle(" -fx-font-size: 45px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ee0000 ;-fx-stroke-width: 1px");
        this.botonesBonus = botonesBonus;
        this.textoPregunta = this.getTextoPregunta();

        this.botonOk = ContenedorPregunta.this.getBotonOk();
        Temporizador.dispararBoton(this.botonOk, this.timerVisual, this.segundos);
        this.setCentro();
        this.setArriba();
        this.setAbajo();
        this.setImagenFondo(rutaFondo);
        this.botonOk.requestFocus();
        stage.setTitle(tipoDePregunta);
        this.seguirCancion = seguirCancion;
        this.ponerCancion();
    }


    abstract protected Pane inicializarContenedorOpciones();

    //CONSTRUCTOR
    public static ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, double segundos, boolean seguirCancion) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();
        boolean valoresPredeterminados = false;
        if(segundos == -1)
            valoresPredeterminados = true;

        if (pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(valoresPredeterminados? 5 : segundos, "Pregunta Verdadero o Falso Clásico", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoVerde.jpg", seguirCancion);

        if (pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(valoresPredeterminados? 10 : segundos, "Pregunta Verdadero o Falso Con Penalidad", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonesMultiplicadores(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoRojo.jpg", seguirCancion);

        if (pregunta instanceof PreguntaMultipleChoiceClasico) {
            return new ContenedorPreguntaMultipleChoice(valoresPredeterminados? 20 : segundos, "Pregunta Multiple Choice Clásico", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoVerde.jpg", seguirCancion);
        }

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(valoresPredeterminados? 20 : segundos, "Pregunta Multiple Choice Parcial", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot),"file:src/main/java/edu/fiuba/algo3/vista/imagenes/anaranjado.png", seguirCancion);

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(valoresPredeterminados? 30 : segundos, "Pregunta Multiple Choice Con Penalidad", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonesMultiplicadores(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/fondoRojo.jpg", seguirCancion);

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(valoresPredeterminados? 30 : segundos, "Pregunta Group Choice", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/violeta.png", seguirCancion);

        return new ContenedorPreguntaOrderedChoice(valoresPredeterminados? 20 : segundos, "Pregunta Ordered Choice", stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot), "file:src/main/java/edu/fiuba/algo3/vista/imagenes/violeta.png", seguirCancion);
    }

    private void ponerCancion() {
        if(seguirCancion) return;
        Musica.musicaPause();
        String rutaCancion = "src/main/java/edu/fiuba/algo3/vista/musica/"+(int)segundos+".wav";
        Musica.musicaPlay(rutaCancion);
    }


    protected void setImagenFondo (String rutaArchivoImagen){
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    protected void setArriba(){
        this.menuBar = new BarraDeMenu(stage);
        Pane filler = new Pane();
        HBox timer = new HBox(filler);
        HBox.setHgrow(filler, Priority.ALWAYS);
        timer.getChildren().add(timerVisual);
        VBox tope = new VBox(menuBar, timer, this.getTextoPregunta());
        tope.setAlignment(Pos.CENTER);
        this.setTop(tope);
    }

    protected void setCentro(){
        Pane filler = new Pane();
        VBox contenedorOpciones = new VBox();
        VBox.setVgrow(filler, Priority.ALWAYS);
        contenedorOpciones.getChildren().add(this.inicializarContenedorOpciones());
        contenedorOpciones.setAlignment(Pos.CENTER);
        this.setCenter(contenedorOpciones);
    }

    protected void setAbajo() {
        HBox botonOkYReset = new HBox(botonOk, this.getBotonReset());
        botonesBonus.setAlignment(Pos.BOTTOM_LEFT);
        botonOkYReset.setAlignment(Pos.CENTER);
        VBox boxDeAbajo = new VBox(botonOkYReset, botonesBonus);
        boxDeAbajo.setAlignment(Pos.CENTER);
        this.setBottom(boxDeAbajo);
    }

    protected Text getTextoPregunta (){
        Text textoPregunta = new Text(kahoot.obtenerPreguntaActual().obtenerTexto());
        textoPregunta.setStyle(" -fx-font-size: 65px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 3px");
        textoPregunta.setWrappingWidth(stage.getWidth());
        textoPregunta.setTextAlignment(TextAlignment.CENTER);
        return textoPregunta;
    }

    protected Button getBotonOk() {
        Button botonOk = new Button("Ok");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setMinSize(150,1);
        botonOk.setOnAction(new BotonOk(kahoot, stage, yaRespondioUnJugador));
        return botonOk;
    }

    protected Button getBotonReset() {
        Button botonResetear = new Button("Resetear");
        botonResetear.setStyle(" -fx-font-size: 2em");
        botonResetear.setMinSize(150,1);
        botonResetear.setOnAction(new ResetearOpcionesElegidas(stage, kahoot, yaRespondioUnJugador));
        return botonResetear;
    }

    protected void cambiarComportamientoBotonOk(EventHandler<ActionEvent> handler){
        this.botonOk.setOnAction(handler);
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
