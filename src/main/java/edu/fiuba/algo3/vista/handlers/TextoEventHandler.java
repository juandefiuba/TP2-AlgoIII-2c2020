package edu.fiuba.algo3.vista.handlers;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class TextoEventHandler implements EventHandler<KeyEvent> {

    private final Button boton;

    public TextoEventHandler(Button boton) {
        this.boton = boton;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        if (keyEvent.getCode() == KeyCode.ENTER){
            boton.fire();
        }
    }
}
