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

public class MarcarOpcionesElegidasMultipleChoice implements EventHandler<ActionEvent> {

    private boolean yaRespondioUnJugador;
    private Kahoot kahoot;
    private Stage stage;

    public MarcarOpcionesElegidasMultipleChoice(Kahoot kahoot, Stage stage){
        this.yaRespondioUnJugador = false;
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()) {
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot.obtenerPreguntaActual().comoInstancia(), kahoot);
            Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escenaPregunta);
        }
        yaRespondioUnJugador = true;
    }
}
