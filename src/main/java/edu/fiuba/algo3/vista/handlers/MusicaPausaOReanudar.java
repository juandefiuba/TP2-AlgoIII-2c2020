package edu.fiuba.algo3.vista.handlers;

import edu.fiuba.algo3.vista.Musica;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;


public class MusicaPausaOReanudar implements EventHandler<ActionEvent> {

    private final MenuItem opcion;

    public MusicaPausaOReanudar(MenuItem opcion){
        this.opcion = opcion;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if(Musica.estaMuteado) {
            Musica.desMutear();
            opcion.setText("Pausar");
        } else {
            Musica.mutear();
            opcion.setText("Play");
        }
    }
}
