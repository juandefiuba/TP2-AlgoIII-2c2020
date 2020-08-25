package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.controlador.ActivarExclusividadHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorDosHandler;
import edu.fiuba.algo3.controlador.MultiplicadorPorTresHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

     public static ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();

        if(pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "clásico", ContenedorPregunta.botonExclusividad(kahoot));

        if(pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "con penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot));

        if (pregunta instanceof PreguntaMultipleChoiceClasico)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "clásico", ContenedorPregunta.botonExclusividad(kahoot));

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "parcial", ContenedorPregunta.botonExclusividad(kahoot));

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "con penalidad", ContenedorPregunta.botonesMultiplicadores(kahoot));

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot));

        return new ContenedorPreguntaOrderedChoice(stage, kahoot, yaRespondioJugador, ContenedorPregunta.botonExclusividad(kahoot));
    }


     public static HBox botonesMultiplicadores(Kahoot kahoot){
        Button multiplicadorX2 = new Button("Multiplicador x2");
        multiplicadorX2.setStyle(" -fx-font-size: 2em");
        multiplicadorX2.setOnAction(new MultiplicadorPorDosHandler(kahoot));
        Button multiplicadorX3 = new Button("Multiplicador x3");
        multiplicadorX3.setStyle(" -fx-font-size: 2em");
        multiplicadorX3.setOnAction(new MultiplicadorPorTresHandler(kahoot));
        HBox contenedorConBoton = new HBox();
        contenedorConBoton.getChildren().addAll(multiplicadorX2, multiplicadorX3);
        return contenedorConBoton;
    }

     public static HBox botonExclusividad(Kahoot kahoot){
        Button exclusividad = new Button("Exclusividad");
        exclusividad.setStyle(" -fx-font-size: 2em");
        exclusividad.setOnAction(new ActivarExclusividadHandler(kahoot));
        HBox contenedorConBoton = new HBox();
        contenedorConBoton.getChildren().add(exclusividad);
        return contenedorConBoton;
    }

    public void setImagenFondo(Kahoot kahoot, Stage stage, String rutaArchivoImagen){
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
    
}