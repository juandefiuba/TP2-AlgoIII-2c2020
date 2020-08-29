package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.contenedores.ContenedorPaseDePantalla;
import edu.fiuba.algo3.vista.contenedores.ContenedorPuntajesFinales;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.LinkedList;

public class BotonOk implements EventHandler<ActionEvent> {

    private boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private LinkedList<Button> opciones;

    public BotonOk(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        Temporizador.stop();
        avanzarTurno(actionEvent, yaRespondioUnJugador, kahoot, stage);
    }

    static void avanzarTurno(ActionEvent actionEvent, boolean yaRespondioUnJugador, Kahoot kahoot, Stage stage) {
        BorderPane proximoContenedor;
        if(yaRespondioUnJugador) {
            if(kahoot.sigueElJuego()) {
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = new ContenedorPaseDePantalla(kahoot, stage, false);
            } else {
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = new ContenedorPuntajesFinales(stage, kahoot);
            }
        } else {
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
            proximoContenedor = new ContenedorPaseDePantalla(kahoot, stage, true);
        }

        Scene escena = new Scene(proximoContenedor, Escena.obtenerEscenaActual().getWidth(), Escena.obtenerEscenaActual().getHeight());
        stage.setScene(escena);
        Escena.setearEscenaActual(escena);
    }
}
