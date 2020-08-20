package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.util.LinkedList;

public class BotonOkMultipleChoice implements EventHandler<ActionEvent> {

    private boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private LinkedList<Button> opciones;

    public BotonOkMultipleChoice(Kahoot kahoot, Stage stage, LinkedList<Button> opciones){
        this.yaRespondioUnJugador = false;
        this.kahoot = kahoot;
        this.stage = stage;
        this.opciones = opciones;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        String nombreJugador = kahoot.obtenerJugadorActual().getNombreJugador();
        int puntaje= kahoot.obtenerJugadorActual().obtenerPuntos();
        stage.setTitle("Pregunta MultipleChoice - Turno de " + nombreJugador + ". Puntaje: " + puntaje);
        for (Button opcion: opciones) {
            opcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 7px; -fx-border-color: #000000");
        }
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()) {
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot);
            Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escenaPregunta);
        }
        yaRespondioUnJugador = true;
    }
}
