package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

    static public ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot, boolean yaRespondioJugador) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();

        if(pregunta instanceof PreguntaVerdaderoFalso)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "clásico");

        if(pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot, yaRespondioJugador, "con penalidad");

        if (pregunta instanceof PreguntaMultipleChoiceClasico)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "clásico");

        if (pregunta instanceof PreguntaMultipleChoiceParcial)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "parcial");

        if (pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot, yaRespondioJugador, "con penalidad");

        if (pregunta instanceof PreguntaGroupChoice)
            return new ContenedorPreguntaGroupChoice(stage, kahoot, yaRespondioJugador);

        return new ContenedorPreguntaOrderedChoice(stage, kahoot, yaRespondioJugador);
    }

    public void setImagenFondo(Kahoot kahoot, Stage stage, String rutaArchivoImagen){
        Image imagen = new Image(rutaArchivoImagen);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
}