package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.RemoverOpcionesElegidasHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ResetearOpcionesElegidas implements EventHandler<ActionEvent> {


    private final Stage stage;
    private final Kahoot kahoot;
    private final boolean yaRespondioUnJugador;
    private final ContenedorPregunta contenedorPregunta;

    public ResetearOpcionesElegidas(Stage stage, Kahoot kahoot, boolean yaRespondioUnJugador, ContenedorPregunta contenedorPregunta) {
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.contenedorPregunta = contenedorPregunta;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        new RemoverOpcionesElegidasHandler(this.kahoot).handle(new ActionEvent());
        contenedorPregunta.setCentro();
    }

}
