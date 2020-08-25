package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Timer;

public class BotonOkVisualGroupChoice implements EventHandler<ActionEvent> {

    private final boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private final VBox vboxOpcionesDadas;
    private final Text mensaje;
    private final Timer conteo;

    public BotonOkVisualGroupChoice(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador, VBox vboxOpcionesDadas, Text mensaje, Timer conteo){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
        this.vboxOpcionesDadas = vboxOpcionesDadas;
        this.mensaje = mensaje;
        this.conteo = conteo;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if (! vboxOpcionesDadas.getChildren().isEmpty()){
            mensaje.setText("Debes completar ambos grupos");
        } else {
            new BotonOk(kahoot, stage, yaRespondioUnJugador, conteo).handle(actionEvent);
        }
    }
}
