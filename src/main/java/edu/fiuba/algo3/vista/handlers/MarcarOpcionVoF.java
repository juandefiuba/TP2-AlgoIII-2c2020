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
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class MarcarOpcionVoF implements EventHandler<ActionEvent> {

    private Opcion opcion;
    private Kahoot kahoot;
    private Stage stage;
    private Label mensajeOk;
    private boolean yaRespondioUnJugador;

    public MarcarOpcionVoF(Opcion opcion, Kahoot kahoot, Stage stage, Label mensajeOk){
        this.opcion = opcion;
        this.stage = stage;
        this.kahoot = kahoot;
        this.yaRespondioUnJugador = false;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        new AgregarOpcionElegidaHandler(kahoot, opcion).handle(actionEvent);
        new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
        //mensajeOk.setText("Respuesta enviada");
        if(yaRespondioUnJugador  &&  kahoot.sigueElJuego()) {
            new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
            ContenedorPregunta contenedorPregunta = ContenedorPregunta.crearContenedor(stage, kahoot.obtenerPreguntaActual().comoInstancia(), kahoot);
            Scene escenaPregunta = new Scene(contenedorPregunta, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
            stage.setScene(escenaPregunta);
        }
        yaRespondioUnJugador = true;
    }

}
