package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class MusicaPlayInfinito implements EventHandler<ActionEvent> {

    private final String ruta;

    public MusicaPlayInfinito(String ruta){
        this.ruta = ruta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Musica.musicaPlaySinFin(ruta);
    }
}
