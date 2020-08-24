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
        BorderPane proximoContenedor;
        if(kahoot.sigueElJuego()){
            new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
            if(yaRespondioUnJugador){
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, false);
            } else {
                new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
                proximoContenedor = ContenedorPregunta.crearContenedor(stage, kahoot, true);
                boton.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #5ae334");
                ///Timer de unos segundos
            }
        } else {
            proximoContenedor = new ContenedorPuntajesFinales(stage, kahoot);
        }
        Scene escenaPregunta = new Scene(proximoContenedor, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escenaPregunta);
    }
}
