package edu.fiuba.algo3.vista;

import javafx.application.Platform;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

import java.util.Timer;
import java.util.TimerTask;

public class CambiadorImagenFondoEntreTurnos {
    static String azul = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/texturaazul.png";
    static String rojo = "file:src/main/java/edu/fiuba/algo3/vista/imagenes/texturaroja.png";
    static String actual = rojo;

    static public String getRutaFondo(){
        if (actual.equals(azul)){
            actual = rojo;
        } else actual = azul;
        return actual;
    }
}