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


public class BotonAgregarOpcionElegida implements EventHandler<ActionEvent> {

    private final Kahoot kahoot;
    private final Stage stage;
    private boolean yaRespondioUnJugador;
    private final Button botonOpcion1;
    private final Button botonOpcion2;

    public BotonAgregarOpcionElegida(Kahoot kahoot, Stage stage, Button botonOpcion1, Button botonOpcion2){
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = false;
        this.botonOpcion1 = botonOpcion1;
        this.botonOpcion2 = botonOpcion2;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.setTitle("Pregunta Verdadero o Falso - Turno de " + "Jugador1");
        botonOpcion1.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        botonOpcion2.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #000000");
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()){
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, false);
            Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escenaPregunta);
        }
        new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        yaRespondioUnJugador = true;
    }
}
