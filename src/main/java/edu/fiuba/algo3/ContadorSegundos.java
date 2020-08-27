package edu.fiuba.algo3;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class ContadorSegundos {

    static public Timer comenzar(Button boton, Text timer){
        Timer conteo = new Timer();
        timer.setStyle(" -fx-font-size: 40px ;-fx-font-weight: bold ; -fx-fill: black;-fx-stroke: #ffffff ;-fx-stroke-width: 2px");
        final int[] numero = {21};
        conteo.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                if (numero[0] > 1){
                    Platform.runLater(() -> timer.setText("" + numero[0]));
                    numero[0]--;
                } else {
                    conteo.cancel();
                    Platform.runLater(boton::fire);
                }
            }
        }, 0, 1000);
        return conteo;
    }
}