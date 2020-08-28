package edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas;

import edu.fiuba.algo3.controlador.*;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import edu.fiuba.algo3.vista.BarraDeMenu;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.handlers.botonesOk.BotonOk;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public abstract class ContenedorPregunta extends BorderPane {

    protected Text textoPregunta; //"private final?"
    protected BarraDeMenu menuBar;
    protected HBox botonesBonus;
    protected Kahoot kahoot;
    protected boolean yaRespondioJugador;
    protected Stage stage;
    protected Text timerVisual;
    protected Button botonOk;
    protected String tipoDePregunta;
    protected Pane contenedorDeOpciones;
    protected double segundos;

    public ContenedorPregunta(Stage stage, HBox botonesBonus, Kahoot kahoot, boolean yaRespondioJugador, double segundos) {
        this.kahoot = kahoot;
        this.stage = stage;
        this.segundos = segundos;
        this.yaRespondioJugador = yaRespondioJugador;
        this.timerVisual = new Text();
        this.timerVisual.setStyle(" -fx-font-size: 30px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ee0000 ;-fx-stroke-width: 1px");
        this.botonesBonus = botonesBonus;
        this.textoPregunta = ContenedorPregunta.this.getTextoPregunta();

        this.botonOk = ContenedorPregunta.this.getBotonOk();
        Temporizador.dispararBoton(this.botonOk, this.timerVisual, this.segundos);
        this.contenedorDeOpciones = this.inicializarContenedorOpciones();
        this.setMenu();
        stage.sizeToScene();
    }

    abstract protected Pane inicializarContenedorOpciones();

    //CONSTRUCTOR
    public static ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();

        if (pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Clásico", ContenedorPregunta.botonExclusividad(kahoot), 10);


        if (pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot), 15);

        if (pregunta instanceof PreguntaMultipleChoiceClasico) {
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Clásico", ContenedorPregunta.botonExclusividad(kahoot), 20);
        }

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Parcial", ContenedorPregunta.botonExclusividad(kahoot), 20);

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot), 30);

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(stage, kahoot, yaRespondioJugador, "Pregunta Group Choice", ContenedorPregunta.botonExclusividad(kahoot), 20);

        return new ContenedorPreguntaOrderedChoice(stage, kahoot, yaRespondioJugador, "Pregunta Ordered Choice", ContenedorPregunta.botonExclusividad(kahoot), 5);
    }

    public static ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador, double segundos) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();


        if (pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Clásico", ContenedorPregunta.botonExclusividad(kahoot), segundos);


        if (pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "Pregunta Verdadero o Falso Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot), segundos);

        if (pregunta instanceof PreguntaMultipleChoiceClasico) {
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Clásico", ContenedorPregunta.botonExclusividad(kahoot), segundos);
        }

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Parcial", ContenedorPregunta.botonExclusividad(kahoot), segundos);

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "Pregunta Multiple Choice Con Penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot), segundos);

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(stage, kahoot, yaRespondioJugador, "Pregunta Group Choice", ContenedorPregunta.botonExclusividad(kahoot), segundos);

        return new ContenedorPreguntaOrderedChoice(stage, kahoot, yaRespondioJugador, "Pregunta Ordered Choice", ContenedorPregunta.botonExclusividad(kahoot), segundos);
    }

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

    protected void setImagenFondo (Kahoot kahoot, Stage stage, String rutaArchivoImagen){
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    protected void setMenu (){
        this.menuBar = new BarraDeMenu(stage);
        botonesBonus.setAlignment(Pos.CENTER_LEFT);
        timerVisual.setTextAlignment(TextAlignment.RIGHT);
        HBox bonusYTimer = new HBox();
        bonusYTimer.setAlignment(Pos.CENTER);
        bonusYTimer.setSpacing(500);
        bonusYTimer.getChildren().addAll(botonesBonus, timerVisual);
        VBox tope = new VBox();
        Button botonResetear = new Button("Resetear");
        botonResetear.setOnAction(e -> {
            double aux = Temporizador.obtenerSegundosRestantes();
            Temporizador.stop();
            new RemoverOpcionesElegidasHandler(this.kahoot).handle(new ActionEvent());
            BorderPane nuevoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, yaRespondioJugador, aux);
            Scene escena = new Scene(nuevoContenedor , TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escena);
        });
        tope.getChildren().addAll(menuBar, bonusYTimer, botonResetear);
        //tope.getChildren().addAll(menuBar, timerVisual);
        tope.setAlignment(Pos.CENTER);
        this.setTop(tope);
    }

    protected Text getTextoPregunta (){
        Text textoPregunta = new Text(kahoot.obtenerPreguntaActual().obtenerTexto());
        textoPregunta.setStyle(" -fx-font-size: 65px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 3px");
        textoPregunta.setWrappingWidth(720);
        textoPregunta.setTextAlignment(TextAlignment.CENTER);
        return textoPregunta;
    }

    protected Button getBotonOk() {
        Button botonOk = new Button("Ok");
        botonOk.setStyle(" -fx-font-size: 2em");
        botonOk.setOnAction(new BotonOk(kahoot, stage, yaRespondioJugador));
        return botonOk;
    }

    protected void cambiarComportamientoBotonOk(EventHandler<ActionEvent> handler){
        this.botonOk.setOnAction(handler);
    }

    protected void randomizarVBox(VBox vbox) {
        LinkedList<javafx.scene.Node> aux = new LinkedList<>(vbox.getChildren());
        Collections.shuffle(aux);
        vbox.getChildren().clear();
        vbox.getChildren().addAll(aux);
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
