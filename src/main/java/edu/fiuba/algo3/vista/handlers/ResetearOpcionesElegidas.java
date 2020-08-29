package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.RemoverOpcionesElegidasHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.Escena;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.Temporizador;
import edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ResetearOpcionesElegidas implements EventHandler<ActionEvent> {


    private final Stage stage;
    private final Kahoot kahoot;
    private final boolean yaRespondioUnJugador;

    public ResetearOpcionesElegidas(Stage stage, Kahoot kahoot, boolean yaRespondioUnJugador) {
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = yaRespondioUnJugador;
    }
    @Override
    public void handle(ActionEvent actionEvent) {
        double aux = Temporizador.obtenerSegundosRestantes();
        Temporizador.stop();
        new RemoverOpcionesElegidasHandler(this.kahoot).handle(new ActionEvent());
        BorderPane nuevoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, yaRespondioUnJugador, aux);
        Scene escena = new Scene(nuevoContenedor, Escena.obtenerEscenaActual().getWidth(), Escena.obtenerEscenaActual().getHeight());
        stage.setScene(escena);
        Escena.setearEscenaActual(escena);
    }

}
