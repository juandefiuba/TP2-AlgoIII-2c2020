package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MusicaPlayOPausa implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
        Musica.musicaPlayOPausa();
    }
}