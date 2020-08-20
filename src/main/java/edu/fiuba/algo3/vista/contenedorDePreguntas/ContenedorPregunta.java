package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

/*    static public ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot){
        return crearContenedor(stage, kahoot.obtenerPreguntaActual().comoInstancia(), kahoot);
    }*/

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaBase pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaVerdaderoFalso pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaVerdaderoFalsoPenalidad pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaOrderedChoice pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaMultipleChoicePenalidad pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaMultipleChoiceParcial pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaMultipleChoiceClasico pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaGroupChoice pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

}