package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;


public class MusicaPausaOReanudar implements EventHandler<ActionEvent> {

    private boolean yaEstaPuesta;
    private final MenuItem opcion;

    public MusicaPausaOReanudar(MenuItem opcion){
        this.yaEstaPuesta = true;
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(yaEstaPuesta) {
            Musica.musicaPause();
            opcion.setText("Reanudar");
            yaEstaPuesta = false;
        } else {
            Musica.musicaReanudar();
            opcion.setText("Pausar");
            yaEstaPuesta = true;
        }
    }
}
