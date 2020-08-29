package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CambiarDeEscena implements EventHandler<ActionEvent> {

    private final Stage stage;
    private final boolean yaRespondioUnJugador;
    private final Kahoot kahoot;

    public CambiarDeEscena(Stage stage, Kahoot kahoot, boolean yaRespondioUnJugador) {
        this.stage = stage;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        BorderPane contenedor = ContenedorPregunta.crearContenedor(stage, kahoot, yaRespondioUnJugador, -1);
        Scene escena = new Scene(contenedor, Escena.obtenerEscenaActual().getWidth(), Escena.obtenerEscenaActual().getHeight());
        stage.setScene(escena);
        Escena.setearEscenaActual(escena);
    }

}
