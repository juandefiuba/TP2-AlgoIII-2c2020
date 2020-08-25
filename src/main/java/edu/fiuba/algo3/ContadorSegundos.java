package edu.fiuba.algo3;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorSegundos {

    static public Timer ContadorSegundos(Button boton, Text timer){
        Timer conteo = new Timer();
        timer.setStyle(" -fx-font-size: 3em");
        final int[] numero = {21};
        conteo.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                if (numero[0] > 1){
                    Platform.runLater(() -> timer.setText("" + numero[0]));
                    numero[0]--;
                } else {
                    conteo.cancel();
                    Platform.runLater(() -> boton.fire());
                }
            }
        }, 0000, 1000);
        return conteo;
    }
}