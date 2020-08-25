package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.ContenedorPuntajesFinales;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.Timer;


public class BotonOkVoF implements EventHandler<ActionEvent> {

    private final Kahoot kahoot;
    private final Stage stage;
    private final Button boton;
    private final Opcion opcion;
    private final Timer conteo;
    private boolean yaRespondioUnJugador;

    public BotonOkVoF(Kahoot kahoot, Stage stage, Opcion opcion, Button botonOpcion, boolean yaRespondioJugador, Timer conteo){
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = yaRespondioJugador;
        this.boton = botonOpcion;
        this.opcion = opcion;
        this.conteo = conteo;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        BorderPane proximoContenedor;
        conteo.cancel();

        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        BotonOk.avanzarTurno(actionEvent, yaRespondioUnJugador, kahoot, stage);
    }
}
