package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.controlador.AvanzarAProximaPreguntaHandler;
import edu.fiuba.algo3.controlador.AvanzarTurnoDeJugadorHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import edu.fiuba.algo3.vista.TamanioDeVentana;
import edu.fiuba.algo3.vista.contenedores.ContenedorPaseDePantalla;
import edu.fiuba.algo3.vista.contenedores.ContenedorPuntajesFinales;
import edu.fiuba.algo3.vista.contenedores.contenedorDePreguntas.ContenedorPregunta;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.util.LinkedList;
import java.util.Timer;

public class BotonOk implements EventHandler<ActionEvent> {

    private final Timer conteo;
    private boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private LinkedList<Button> opciones;

    public BotonOk(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador, Timer conteo){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
        this.conteo = conteo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        BorderPane proximoContenedor;
        conteo.cancel();
        avanzarTurno(actionEvent, yaRespondioUnJugador, kahoot, stage);
    }

    static void avanzarTurno(ActionEvent actionEvent, boolean yaRespondioUnJugador, Kahoot kahoot, Stage stage) {
        BorderPane proximoContenedor;
        if(yaRespondioUnJugador) {
            if(kahoot.sigueElJuego()) {//NO estamos en la ultima pregunta
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = new ContenedorPaseDePantalla(kahoot, stage, false);
            } else {
                new AvanzarAProximaPreguntaHandler(kahoot).handle(actionEvent);
                proximoContenedor = new ContenedorPuntajesFinales(stage, kahoot);
            }
        } else {
            new AvanzarTurnoDeJugadorHandler(kahoot).handle(actionEvent);
            proximoContenedor = proximoContenedor = new ContenedorPaseDePantalla(kahoot, stage, true);
        }

        Scene escena = new Scene(proximoContenedor, TamanioDeVentana.anchoPredeterminado(), TamanioDeVentana.altoPredeterminado());
        stage.setScene(escena);
    }
}
