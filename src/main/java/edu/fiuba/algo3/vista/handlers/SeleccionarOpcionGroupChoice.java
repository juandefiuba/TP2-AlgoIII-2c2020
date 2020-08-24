package edu.fiuba.algo3.vista.handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SeleccionarOpcionGroupChoice implements EventHandler<ActionEvent> {

    private final Button pasarAGrupo1;
    private final Button pasarAGrupo2;
    private final Button botonOpcion;
    private final VBox grupo1;
    private final VBox grupo2;
    private final VBox grupoActual;
    private final Button botonOk;

    public SeleccionarOpcionGroupChoice(Button botonOpcion, Button pasarAGrupo1, Button pasarAGrupo2, VBox grupo1, VBox grupo2, VBox grupoActual, Button botonOk) {
        this.botonOpcion = botonOpcion;
        this.pasarAGrupo1 = pasarAGrupo1;
        this.pasarAGrupo2 = pasarAGrupo2;
        this.botonOk = botonOk;
        this.grupo1 = grupo1;
        this.grupo2 = grupo2;
        this.grupoActual = grupoActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        botonOpcion.setStyle("-fx-font-size: 2.9em; -fx-border-width: 5px; -fx-border-color: #46c2b8");
        pasarAGrupo1.setOnAction(new cambiarBotonDeContenedor(botonOpcion, grupoActual, grupo1, botonOk));
        pasarAGrupo2.setOnAction(new cambiarBotonDeContenedor(botonOpcion, grupoActual, grupo2, botonOk));
    }
}
