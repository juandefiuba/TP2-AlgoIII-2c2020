package edu.fiuba.algo3.controlador;

import edu.fiuba.algo3.modelo.Kahoot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RemoverOpcionesElegidasHandler implements EventHandler<ActionEvent> {
    private final Kahoot kahoot;

    public RemoverOpcionesElegidasHandler(Kahoot kahoot) {
        this.kahoot = kahoot;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        kahoot.removerOpcionesElegidas();
    }
}