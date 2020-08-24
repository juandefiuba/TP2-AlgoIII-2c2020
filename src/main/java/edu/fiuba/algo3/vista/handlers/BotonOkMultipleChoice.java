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

    public BotonOkMultipleChoice(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()) {
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, false);
            Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escenaPregunta);
            return;
        }
        new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, true);
        Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaPregunta);
    }
}
