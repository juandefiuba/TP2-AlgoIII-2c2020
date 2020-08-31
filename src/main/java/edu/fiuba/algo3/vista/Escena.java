package edu.fiuba.algo3.vista;

import javafx.scene.Scene;

public class Escena {
    private static Scene escenaActual;

    public static void setearEscenaActual(Scene escena) {
        escenaActual = escena;
    }

    public static Scene obtenerEscenaActual(){
        return escenaActual;
    }
}
