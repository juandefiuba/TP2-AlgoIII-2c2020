package edu.fiuba.algo3.vista.contenedorDePreguntas;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Preguntas.PreguntaBase;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ContenedorPregunta extends BorderPane {

    static public ContenedorPregunta crearContenedor(Stage stage, Kahoot kahoot){
        return crearContenedor(stage, kahoot.obtenerPreguntaActual().comoInstancia(), kahoot);
    }

    static public ContenedorPregunta crearContenedor(Stage stage, PreguntaBase pregunta, Kahoot kahoot){
        return new ContenedorPreguntaVoF(stage, kahoot);
    }

}