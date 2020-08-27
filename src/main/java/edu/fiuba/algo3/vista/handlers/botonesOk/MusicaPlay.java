package edu.fiuba.algo3.vista.handlers.botonesOk;

import edu.fiuba.algo3.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MusicaPlay implements EventHandler<ActionEvent> {

    private final String ruta;

    public MusicaPlay(String ruta){
        this.ruta = ruta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Musica.musicaPlay(ruta);
    }
}
