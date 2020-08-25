package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class TextoEventHandler implements EventHandler<KeyEvent> {

    private final Button boton;

    public TextoEventHandler(Button boton) {
        this.boton = boton;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            Event.fireEvent(boton, new ActionEvent());
        }
    }
}
