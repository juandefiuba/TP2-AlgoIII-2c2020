package edu.fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {

    private static Timer timer;
    private static double[] numero;

     public static void dispararBoton(Button boton, Text timerVisual, double segundos){
        timer = new Timer();
        numero = new double[] {segundos};
        timer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                if (numero[0] > 0.05){
                    Platform.runLater(() -> {
                        //Para acortar la precision del double
                        timerVisual.setText(BigDecimal.valueOf(numero[0]).setScale(1, RoundingMode.HALF_UP).doubleValue()+"");
                    });
                    numero[0] = numero[0]-0.1;
                } else {
                    timer.cancel();
                    Platform.runLater(boton::fire);
                }
            }
        }, 0, 100);
    }

    public static void stop() {
         timer.cancel();
    }

    public static double obtenerSegundosRestantes() {
         return numero[0];
    }
}