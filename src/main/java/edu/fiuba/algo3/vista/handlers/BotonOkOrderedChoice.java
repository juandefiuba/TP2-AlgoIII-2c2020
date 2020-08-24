package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BotonOkOrderedChoice implements EventHandler<ActionEvent> {

    private Kahoot kahoot;
    private Stage stage;
    private boolean yaRespondioUnJugador;

    public BotonOkOrderedChoice(Stage stage, Kahoot kahoot, boolean yaRespondioUnJugador){
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
    }

    public void handle(ActionEvent actionEvent){
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()){
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            yaRespondioUnJugador = false;
        } else {
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
            yaRespondioUnJugador = true;
        }
        ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, yaRespondioUnJugador);
        Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaPregunta);
    }
}
