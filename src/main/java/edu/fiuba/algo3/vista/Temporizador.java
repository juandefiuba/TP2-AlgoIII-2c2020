package edu.fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {

    private static Timer timer;

     public static Timer comenzar(Button boton, Text timerVisual, int segundos){
        timer = new Timer();
        final int[] numero = {segundos};
        numero[0]++;
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                if (numero[0] > 1){
                    Platform.runLater(() -> timerVisual.setText("Quedan " + numero[0] + " segundos"));
                    numero[0]--;
                } else {
                    timer.cancel();
                    Platform.runLater(boton::fire);
                }
            }
        }, 0, 1000);
        return timer;
    }

    public static void stop() {
         timer.cancel();
    }




}