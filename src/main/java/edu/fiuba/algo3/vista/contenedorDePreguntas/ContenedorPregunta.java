package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

    static public ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot) {
        Pregunta pregunta = kahoot.obtenerPreguntaActual();

        if (pregunta instanceof PreguntaVerdaderoFalso || pregunta instanceof PreguntaVerdaderoFalsoPenalidad)
            return new ContenedorPreguntaVoF(stage, kahoot);

        if (pregunta instanceof PreguntaMultipleChoiceClasico || pregunta instanceof PreguntaMultipleChoiceParcial || pregunta instanceof PreguntaMultipleChoicePenalidad)
            return new ContenedorPreguntaMultipleChoice(stage, kahoot);

        if (pregunta instanceof PreguntaOrderedChoice)
            return new ContenedorPreguntaOrderedChoice(stage, kahoot);

        return new ContenedorPreguntaGroupChoice(stage, kahoot);
    }
}