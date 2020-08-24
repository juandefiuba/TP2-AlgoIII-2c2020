package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.controlador.AgregarOpcionElegidaHandler;
import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.modelo.Opciones.Opcion;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
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
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);

        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()){
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            yaRespondioUnJugador = false;
        } else {
            yaRespondioUnJugador = true;
            boton.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #5ae334");
            ///Timer de unos segundos
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        }

        ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot, yaRespondioUnJugador);
        Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaPregunta);
    }
}
