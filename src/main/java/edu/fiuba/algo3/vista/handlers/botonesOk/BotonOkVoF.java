package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.Musica;
import edu.fiuba.algo3.vista.Temporizador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class BotonOkVoF implements EventHandler<ActionEvent> {

    private final Kahoot kahoot;
    private final Stage stage;
    private final Button boton;
    private final Opcion opcion;
    private boolean yaRespondioUnJugador;

    public BotonOkVoF(Kahoot kahoot, Stage stage, Opcion opcion, Button botonOpcion, boolean yaRespondioJugador){
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = yaRespondioJugador;
        this.boton = botonOpcion;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Temporizador.stop();
        Musica.musicaPause();
        Musica.musicaPlay("src/main/java/edu/fiuba/algo3/vista/musica/final.wav");
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        BotonOk.avanzarTurno(actionEvent, yaRespondioUnJugador, kahoot, stage);
    }
}
