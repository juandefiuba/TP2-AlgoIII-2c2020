package edu.fiuba.algo3.vista.handlers.botonesOk;


import edu.fiuba.algo3.controlador.RemoverOpcionesElegidasHandler;
import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonOkGroupChoice implements EventHandler<ActionEvent> {

    private final boolean yaRespondioUnJugador;
    private final Kahoot kahoot;
    private final Stage stage;
    private final VBox vboxOpcionesDadas;

    public BotonOkGroupChoice(Kahoot kahoot, Stage stage, boolean yaRespondioUnJugador, VBox vboxOpcionesDadas){
        this.yaRespondioUnJugador = yaRespondioUnJugador;
        this.kahoot = kahoot;
        this.stage = stage;
        this.vboxOpcionesDadas = vboxOpcionesDadas;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        if (! vboxOpcionesDadas.getChildren().isEmpty()){
            new RemoverOpcionesElegidasHandler(kahoot).handle(actionEvent);
        }
        new BotonOk(kahoot, stage, yaRespondioUnJugador).handle(actionEvent);
    }
}
