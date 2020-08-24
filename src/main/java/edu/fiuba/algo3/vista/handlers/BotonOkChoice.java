package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.ContenedorPuntajesFinales;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class BotonOkChoice implements EventHandler<ActionEvent> {

    private boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private LinkedList<Button> opciones;

    public BotonOkChoice(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BorderPane proximoContenedor;

        if(yaRespondioUnJugador) {
            if(kahoot.sigueElJuego()) {//NO estamos en la ultima pregunta
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, false);
            } else {
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = new ContenedorPuntajesFinales(stage, kahoot);
            }
        } else {
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
            proximoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, true);
        }

        Scene escena = new Scene(proximoContenedor, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escena);
    }
}
