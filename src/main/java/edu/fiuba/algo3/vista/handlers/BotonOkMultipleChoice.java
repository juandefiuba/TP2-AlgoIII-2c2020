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
        if(!kahoot.sigueElJuego() && yaRespondioUnJugador) {
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            String nombreJugador1 = kahoot.obtenerJugadorActual().getNombreJugador();
            int puntaje1 = kahoot.obtenerJugadorActual().obtenerPuntos();
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
            String nombreJugador2 = kahoot.obtenerJugadorActual().getNombreJugador();
            int puntaje2 = kahoot.obtenerJugadorActual().obtenerPuntos();
            stage.setTitle("Puntaje total de" + nombreJugador1 + " : " + puntaje1 + " Puntaje total de" + nombreJugador2 + " :" + puntaje2);
            //Scene escena = new Scene(TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            return;
        }
        if(yaRespondioUnJugador) {
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
